package lesson2.homework;

import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;


public class HomeWorkTwo {
    public static void main(String[] args) {
        //palindrome();
        //testInFile();
        String path = "C:\\Users\\Anika\\Desktop\\lessonjava\\untitled\\src\\main\\java\\lesson2\\homework";
        fileExtension(path);
    }

    /**
     * Задача 1.Напишите метод, который принимает на вход строку (String) и определяет является ли строка
     * палиндромом (возвращает boolean значение).
     */
    public static void palindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s = scanner.nextLine().replaceAll("\\p{Punct}|\\p{Space}", "").toLowerCase();
        scanner.close();  // !"#$%&'()*+,-./:;<=>?@[\]^_\`{|}~

        boolean palindrom = false;
        int j = s.length() - 1;
        for (int i = 0; i <= s.length() / 2 - 1; i++) {
            if (s.charAt(i) == s.charAt(j)) {
                j--;
                palindrom = true;
            } else {
                palindrom = false;
            }
        }
        System.out.println(palindrom);
    }
    /**
     * Задача 2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
     * который запишет эту строку в простой текстовый файл, обработайте исключения.
     */
    public static void testInFile() {

        try (FileWriter fw = new FileWriter("C:\\Users\\Anika\\Desktop\\lessonjava\\untitled\\src\\main\\" +
                "java\\resources\\file.txt", true)) {
            String text = "TEST ";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(text);
            }
            fw.write(String.valueOf(sb));
            fw.flush();
            System.out.println("Done");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    /**
     * Задача 3*. Напишите метод, который определит тип (расширение) файлов из текущей папки и
     * выведет в консоль результат вида:
     * 1 Расширение файла: txt
     * 2 Расширение файла: pdf
     * 3 Расширение файла:
     * 4 Расширение файла: jpg
     */
    public static void fileExtension(String path) {
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.toString();
                int index = fileName.lastIndexOf('.');
                if(index > 0) {
                    String extension = fileName.substring(index + 1);
                    System.out.println("Расширение файла:" + extension);
                }
            }
        }
    }
}

























