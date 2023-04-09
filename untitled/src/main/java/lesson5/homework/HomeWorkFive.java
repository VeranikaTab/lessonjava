package lesson5.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWorkFive {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }



    // 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    private static void ex1() {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("79025201212", "Иванов");
        phonebook.put("79020005512", "Иванов");
        phonebook.put("79648801212", "Петров");
        phonebook.put("79029898182", "Иванова");
        phonebook.put("79777771555", "Жданов");
        phonebook.put("79978700121", "Федин");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую фамилию ищем?");
        String name = scanner.next();

        for (Map.Entry<String, String> phoneMapEntry : phonebook.entrySet()) {
            if (phoneMapEntry.getValue().equals(name)) {
                System.out.printf("%s\t-> %s%n", phoneMapEntry.getKey(), phoneMapEntry.getValue());
            }
        }
    }
    // 2. Пусть дан список сотрудников:
    //Иван Иванов//Светлана Петрова//Кристина Белова//Анна Мусина//Анна Крутова//Иван Юрин//Петр Лыков//Павел Чернов
    //Петр Чернышов//Мария Федорова//Марина Светлова//Мария Савина//Мария Рыкова//Марина Лугова//Анна Владимирова
    //Иван Мечников//Петр Петин//Иван Ежов
    //Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    private static void ex2 () {
        Map<String, Integer> list = new HashMap<>();
        String str = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, " +
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, " +
                "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        str = str.replace(",", "");

        String[] arr = str.split(" ");
        ArrayList name = new ArrayList();

        for (int i = 0; i < arr.length; i += 2) {
            name.add(arr[i]);
        }
        TreeMap<Object, Integer> map = new TreeMap<>();
        for (int i = 0; i < name.size(); i++) {
            if (map.containsKey(name.get(i))) {
                int count = map.get(name.get(i)) + 1;
                map.put(name.get(i), count);
            } else {
                map.put(name.get(i), 1);
            }
        }
        System.out.println(name);

        map.entrySet().stream().sorted(Map.Entry.<Object, Integer>comparingByValue().reversed()).forEach(System.out::println);
        }

// 3***. Написать метод, который переведёт данное целое число в римский формат.
//    В ней вместо цифр используются римские буквы: I — 1, V — 5, X — 10, L — 50, C — 100, D — 500, M — 1000.
//    В античности правила перешли от сложения к вычитанию и появились шесть новых комбинаций: IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900.
//    Цифры могут повторяться, но не более трёх одинаковых подряд.
//    Если меньшая цифра стоит справа от такой же или большей, то они складываются друг с другом: VIII → 8.
//    если меньшая цифра стоит слева от большей — вычитаем из большего меньшее: IV → 4.
    private static void ex3() {
    Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число от 1 до 3999: ");
        Integer num = sc.nextInt();
		System.out.println(toRoman(num));
        sc.close();}
    public static String toRoman(Integer num) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        int num2 = map.floorKey(num);
        if (num == num2) {
            return map.get(num);
        }
        return map.get(num2) + toRoman(num - num2);
}
}




