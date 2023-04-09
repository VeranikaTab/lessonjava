package lesson5;
import java.util.HashMap;
import java.util.Map;
public class MainClassFromLessonFive {

    public static void main(String[] args) {
        //ex0();
        //System.out.println("MMCMXCIX -> " +  fromRomanToArabic("MMCMXCIX"));
        System.out.println("MMCMXCIX -> " +  ex3("MMCMXCIX"));
    }

    //*Задача 0. Создать структуру для хранения номеров паспортов и фамилий сотрудников организации
// Вывести данные по фамилии Иванов*/
    private static void ex0() {
        Map<String, String> passportsToSernameMap = new HashMap<>();
        passportsToSernameMap.put("123456", "Иванов");
        passportsToSernameMap.put("321456", "Васильев");
        passportsToSernameMap.put("234561", "Петров");
        passportsToSernameMap.put("234432", "Иванова");
        passportsToSernameMap.put("654321", "Петрова");
        passportsToSernameMap.put("345678", "Иванов");

        System.out.println(passportsToSernameMap);

        for (Map.Entry<String, String> entry : passportsToSernameMap.entrySet()) {
            System.out.printf("%s\t%s%n", entry.getKey(), entry.getValue());
        }

/*        for (String key : passportsToSernameMap.keySet()) {
            System.out.printf("%s\t%s%n", key, passportsToSernameMap.get(key));
        }*/

/*        passportsToSernameMap.forEach((key, value) -> System.out.printf(
                "%s\t%s%n",
                key, value)
        );
        // мой вариант решения
            for (Map.Entry<String, String> entry : passportsToSernameMap.entrySet()) {
        if (entry.getValue().equals("Иванов")){
            System.out.printf("%s\t%s%n", entry.getKey(), entry.getValue());
        }

        }*/
    }

    // Задача 3. Написать метод, который переведет число из римского формата записи в арабский.
// Например, MMXXII = 2022
    private static Integer ex3(String romanNum) {

        Map<Character, Integer> romanToDecimalMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );// оф - можно добавить максимум10 элементов через запятую. на выходе получаем неизменяем

        StringBuilder romanNumSB = new StringBuilder(romanNum.trim()).reverse();
        // только для разворота. от посл к первому, чтобы посл символ отдельно не обрабатывать
        int decimalNum = 0; // десятичное число
        int prevNum = -1; // предыдущее значение

        for (Character romanChar : romanNumSB.toString().toCharArray()) {
            // после переворота перегоняем все в массив
            int currentNum = romanToDecimalMap.get(romanChar);
            if (currentNum < prevNum) {
            //проверка: currentNum знак положит или отрицательный
                currentNum *= -1;
            }
            decimalNum += currentNum;
            prevNum = currentNum;
        }
        return decimalNum;
    }

    //* решение на семинаре задачи 3. так лучше не делать.
    private static int fromRomanToArabic(String num) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("I", 1);
        numbers.put("V", 5);
        numbers.put("X", 10);
        numbers.put("L", 50);
        numbers.put("C", 100);
        numbers.put("D", 500);
        numbers.put("M", 1000);

        int sum = 0;
        int next = -1;
        for (int i = 0; i < num.length() - 1; i++) {
            int current = numbers.get(num.charAt(i) + "");
            next = numbers.get(num.charAt(i + 1) + "");
            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        sum += next;
        return sum;
    }
}



