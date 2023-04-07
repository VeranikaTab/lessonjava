package lesson4.homework;

import java.util.*;

public class HomeWorkFour {

    public static void main(String[] args) {
        ex1();
        ex2();
    }
//    1. Реализовать консольное приложение, которое:
//    Принимает от пользователя и “запоминает” строки.
//    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//    Если введено revert, удаляет предыдущую введенную строку из памяти.

    private static void ex1() {
        List<String> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String tempString = "";
        while (!tempString.toLowerCase().equals("txt")) {
            System.out.println("Введите строку:");
            tempString = scanner.nextLine();
            if (tempString.toLowerCase().equals("print")) {
                Collections.reverse(linkedList);
                System.out.println(linkedList);
                Collections.reverse(linkedList);
            } else if (tempString.toLowerCase().equals("revert")) {
                if (!linkedList.isEmpty()) {
                    linkedList.remove(linkedList.size() - 1);
                    System.out.println(linkedList);
                } else {
                    System.out.println("Список пуст.");
                }
            }else  if (tempString.equalsIgnoreCase("stop")) {
                    break;
            } else {
                linkedList.add(tempString);
            }
        }
        scanner.close();
    }
// 2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

    private static void ex2() {
        Random random = new Random();
        List<Integer> randomLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            randomLinkedList.add(random.nextInt(1, 20));
        }
        System.out.println("Список: " + randomLinkedList.toString());

        List<Integer> RevertLinkedList = new LinkedList<>();
        for (int i = randomLinkedList.size() - 1; i >= 0; i--) {
            RevertLinkedList.add(randomLinkedList.get(i));
        }
        System.out.println("'Перевёрнутый' список: " + RevertLinkedList.toString());
    }
}