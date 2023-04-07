package lesson4;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class MainClassFromLessonFour {
    private static Scanner fileScanner;
    private static PrintWriter printWriter;
    private static File file;
    public static void main(String[] args) {
        //ex0();
        ex1();
    }
//** Задание 0. 1. Замерьте время за которое в ArrayList добавятся 10000 элементов.
// 2. Замерьте время за которое в linkedList добавятся 10000 элементов. Сравните с предыдущим */

    private static void ex0() {
        final int SIZE = 10_000;
        Random random = new Random();

        List<Random> linkedList = new LinkedList<>();
        //List<Integer> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis(); // текущее кол-во мс 1970г
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(null);
            // linkedList.add(random.nextInt());
            // linkedList.add(new Random);
            // linkedList.add(0, new Random); //0-в самое начало добавить
        }
        System.out.println("LinkedList: " + (System.currentTimeMillis() - start));

        List<Random> arrayList = new ArrayList<>(SIZE);
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(null);
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));
    }
//* Задача 1. Реализовать консольное приложение, которое:
// 1. Принимает от пользователя строку вида text~num
// 2. Нужно рассплитить строку по ~ , сохранить text в связанный список на позицию num
// 3. Если введено print ~ num , выводит строку из позиции num  в связанном списке и удаляет ее из списка*/
    private static void ex1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");
        // Метод Collections.addAll принимает на входе объект Collection и массив.
        // работает не только с List, но и с любой другой коллекцией.

        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.trim().length() == 0) {
                // Метод trim() в Java позволяет удалить пробелы в начале и конце строки.
//            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue; // если длинн введенного равно 0, то переходим к следующему иф
            }
            if (inputString.equalsIgnoreCase("stop")) {
                // .equalsIgnoreCase сравнивает данную строку с другой строкой, игнорируя регистр.
                break; // ЕСЛИ ВВЕДЕН stop ЗАВЕРШИТСЯ
            }
            if (inputString.equalsIgnoreCase("print~all")) {
                printAllNotNullValues(wordsList);//если введено принт олл вызываем метод
                // printAllNotNullValues - внизу метод
                continue;
            }
            if (!inputString.contains("~")) {
                // далее проверка на тильду
                //*Java String contains()- метод чтобы проверить, содержит ли String указанную
                // последовательность символов. Этот метод возвращает логический тип данных,
                // который является результатом тестирования, если строка содержит символы,
                // указанные в аргументе метода в типе объекта CharSequence. Метод contains()
                // возвращает true тогда и только тогда, когда эта строка содержит указанную
                // последовательность значений char.*/
                System.out.println("Строка не содержит тильду");
                continue;
            }

            String[] parts = inputString.split("\\~"); // если тильда имеется
            //* split() возвращает массив строк, вычисленных путем разделения данной строки
            // вокруг данного регулярного выражения.*/

            if (parts.length != 2) { // если части между тильдой не две выводится
                System.out.println("Ошибка ввода шаблона. Должно быть \"word~num\". Пример: apple~6");
                continue; // переход к сл итерации
            }

            String word = parts[0]; // само слово складываем в перем ворд
            int num = 0;

            try { // и переводим в целое число
                num = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) { // если ошибка то выводим сообщение
                System.out.println("Выражение не содержит числа");
                continue;
            }

            if (num < 1) { // проверка на отрицательное значение num
                System.out.println("Введите num более 1");
                continue;
            }

            if (word.equalsIgnoreCase("print")) { // печать: проверка , что слово = print
                // проверяем попадаем ли мы в диапазон нашего листа, есть ли такое значение
                //спец методом isNumberInRange. и вторая проверка, что значение существует valueIsNull
                if (!isNumberInRange(num, wordsList.size()) || valueIsNull(wordsList, num)) {
                    //
                    System.out.println("Указанного значения не существует");
                } else {
                    System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num - 1));
                    wordsList.remove(num - 1); //удаляем выведенное значение
                }
            } else if (isNumberInRange(num, wordsList.size())) { // добавление:
                String oldWord = wordsList.get(num - 1);

                if (valueIsNull(wordsList, num)) {// если значения не существовало, то добавляем
                    printAddMessage(word, num); // через метод ниже

                } else {
                    printSetMessage(word, num, oldWord);// если уже было, то заменило
                }
                // если добавляем в рамках диапазона, то обновляем его через set. старое затирается
                wordsList.set(num - 1, word);
            } else { // если число = размету или больше
                //
                int nullCount = num - wordsList.size() - 1; // позиции которые пустые не печетаем
                addNulls(wordsList, nullCount);
                wordsList.add(word);
                printAddMessage(word, num);
            }
        }
    }

    private static void addNulls(LinkedList<String> wordsList, int count) {
        for (int i = 0; i < count; i++) {
            wordsList.add(null);
        }
    }

    private static void printAllNotNullValues(LinkedList<String> wordsList) {
        // пробегает по всем элем внутри списка и выводит на экран, предварительно уточняя
        // не является ли null
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i) != null) {
                System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
            }
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordsList, int num) {
        return wordsList.get(num - 1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        return num >= 1 & num <= size;
    }
}
// ВАРИАНТ РЕШЕНИЯ НА СЕМИНАРЕ

