package lesson3.homework;

import java.util.*;
import java.util.stream.Collectors;
import static com.sun.beans.introspect.ClassInfo.clear;
import static com.sun.beans.introspect.ClassInfo.get;

public class HomeWorkThree {
    public static void main(String[] args) {
        hw1();
        hw2();
        hw3();
        hw4();
    }

    // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа
// (в языке уже есть что-то готовое для этого)
    private static void hw1() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < 15; j++) {
            int number = random.nextInt(1, 15);
            list.add(number);
        }
        System.out.printf("Произвольный список %s\n", list);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.printf("Из списка удалены все четные числа %s\n", list);
        System.out.println();
    }

    //2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
    private static void hw2() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            int number = random.nextInt(1, 10);
            list.add(number);
        }

        System.out.printf("Список чисел %s\n", list);

        Optional<Integer> min = list.stream().min(Integer::compare);
        System.out.printf("минимальное %s\n", min.get());
        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.printf("максимальное %s\n", max.get());
        OptionalDouble average = list.stream().mapToInt(a -> a).average();
        System.out.printf("среднее арифметическое %s\n", average.getAsDouble());
//        //int min1 = Collections.min(list);
//        //System.out.printf("минимальное- %s\n", min1);
//        System.out.printf("минимальное %s\n", list.stream().min(Comparator.naturalOrder()).get());
//        System.out.printf("максимальное %s\n", list.stream().mapToInt(a -> a).max().getAsInt());
//        System.out.printf("среднее арифметическое %s\n", list.stream().mapToInt(a -> a).average().getAsDouble());
//        //System.out.println(list.stream().mapToInt(Integer::intValue).summaryStatistics());
//        //общая статистика{count= , sum= , min= , average= , max= }
        System.out.println();
    }

    //* 3. Доделать начатое на семинаре. Пройти по списку из предыдущего задания и удалить повторяющиеся элементы. */
    public static void hw3() {
        List<String> planetsNames = List
                .of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluton");
        Random random = new Random();
        List<String> listWithDuplicates = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            listWithDuplicates.add(planetsNames.get(random.nextInt(9)));
        }
        //System.out.println(listWithDuplicates);
        listWithDuplicates.sort(Comparator.naturalOrder());
        System.out.println(listWithDuplicates);

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < listWithDuplicates.size() - 1; i++) {
            if (listWithDuplicates.get(i).equals(listWithDuplicates.get(i + 1))) {
                count++;
            } else {
                sb.append(listWithDuplicates.get(i))
                        .append(": ")
                        .append(count)
                        .append("; ");
                count = 1;
            }
        }
        sb.append(listWithDuplicates.get(listWithDuplicates.size() - 1)).append(": ").append(count).append(".");

        System.out.println(sb);
// решение 0 вариант -------------------------------------------------------------------------
        for (int i = 1; i < listWithDuplicates.size(); i++) {
            if (listWithDuplicates.get(i).equals(listWithDuplicates.get(i - 1))) {
                listWithDuplicates.remove(i);
                i--;
            }
        }
        System.out.println(listWithDuplicates);
        System.out.println();

// // --- Первый вариант --------------------------------------------------------------------
//        listWithDuplicates.sort(Comparator.naturalOrder());
//        System.out.println(listWithDuplicates);// входной список с дубликатами
//        // Создаем новый список из набора, составленного из элементов исходного списка
//        List<String> list = listWithDuplicates.stream().distinct() // сохраняем порядок
//                .collect(Collectors.toList()); //преобразование к типу List
//        System.out.println(list);
//    }
// //--- Второй вариант --------------------------------------------------------------------
// строим множество из элементов списка. множество не допускает повторяющихся элементов
//        Set<String> set = new LinkedHashSet<>(listWithDuplicates);
//
//        // создаем новый список из набора и печатаем его
//        List<String> listWithoutDuplicates = new ArrayList<>(set);
//
//        System.out.println(listWithoutDuplicates);
//      }

// // ---Третий вариант -----------------------------------------------------------------------
//        int count = 0;
//        Iterator<String> iterator = planetsNames.iterator();
//        while (iterator.hasNext()) {
//            // С помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли конец коллекции
//            if (Collections.frequency(planetsNames, iterator.next()) > 1) {//если повторяется больше 1 раза
//                // frequency(colls, obj)  -  Определяет, сколько раз элемент obj встречается в коллекции colls
//                count++;
//                iterator.remove(); // удалить
//            }
//        }
//        System.out.println(planetsNames);
//      }
// //-----------------------------------------------------------------------------------

}

//4*. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.
    private static void hw4() {
        ArrayList<String> listNew = new ArrayList<>();
        listNew.add("Life");
        listNew.add("Hope");
        listNew.add("695");
        listNew.add("Faith");
        listNew.add("Love");
        listNew.add("15");
        System.out.println(listNew);
        for (int i = 0; i < listNew.size(); i++) {
            String str1 = listNew.get(i);
            try {
                Integer s = Integer.valueOf(str1);
                listNew.remove(i);
                System.out.println(s);
            } catch (NumberFormatException e) {
                System.err.println("Неправильный формат строки!");
            }
        }
        System.out.println(listNew);
    }
}


