package lesson2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class MainClassFromLessonTwo {
    public static void main(String[] args) {
        /**test();
        returnNchar();
        ex1();
        countCompression();
        ex2_1();
        ex2_2();*/
        ex5("C:\\Users\\Anika\\Desktop\\lessonjava\\untitled\\src\\main\\java");

    }
        private static void test() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 65536; i++) {
                sb.append("i: ").append(i).append(" -> ").append((char)i).append(System.lineSeparator());
            }
            System.out.println(sb);
        }
        /** Задача 1. Дано число N(>0) и символы с1 и с2. Написать метод, который вернет строку длины N,
         которая состоит из чередующихся символов с1 и с2, начиная с с1.*/
        public static void returnNchar() {
        int N = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(i%2!=0) {
                sb.append("V");
            }else{
                sb.append("v");
            }
        }System.out.println(sb);}

        /** ----------------  2-й вариант от преподавателя */
        private static void ex1() {
            char firstSymbol = 'A';
            char secondSymbol = '_';
            StringBuilder sb = new StringBuilder();
            int n = 7;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sb.append(firstSymbol);
                } else {
                    sb.append(secondSymbol);
                }}
            System.out.println(sb);
        }

        /** Задача 2. Напишите метод, который сжимает строку. Например: вход aaaabbbcdd.*/
        public static void countCompression() {
        String str = "aaaabbbcdd";
        StringBuilder newStr = new StringBuilder();
        int count = 1;
        char[] arr = str.toCharArray();
            for (int i = 0; i <str.length()-1; i++) {
                if (arr[i]==arr[i+1])
                    count++;
                else {
                    newStr.append(arr[i]).append(count);
                    count=1;
            }}
            newStr.append(str.charAt(str.length()-1)).append(count);
            System.out.println(newStr);}
        /** ----------------  2-й вариант от преподавателя */
        private static void ex2_1() {
        String longString = "aaaabbbcdd";
        StringBuilder shortStringSB = new StringBuilder();
        char prev = longString.charAt(0);
        char curr = prev;
        int counter = 1;

        for (int i = 1; i < longString.length(); i++) {
            prev = longString.charAt(i - 1);
            curr = longString.charAt(i);
            if (prev != curr) {
                shortStringSB.append(prev);
                shortStringSB.append((counter > 1) ? counter : "");
                counter = 0;
            }
            counter++;
        }
        shortStringSB.append(curr);
        shortStringSB.append((counter > 1) ? counter : "");

        System.out.printf("%s -> %s%n", longString, shortStringSB);
        }
        /** ----------------  3-й вариант от преподавателя */
        private static void ex2_2() {
        String longString = "aaaabbbcdd";
        StringBuilder shortStringSB = new StringBuilder();
        char[] charStringArr = longString.toCharArray();
        char curr = 0;
        char next = 0;
        int counter = 0;

        for (int i = 0; i < charStringArr.length - 1; i++) {
            counter++;
            curr = charStringArr[i];
            next = charStringArr[i + 1];
            if (curr != next) {
                shortStringSB.append(curr);
                shortStringSB.append((counter > 1) ? counter : "");
                counter = 0;
            }}
        shortStringSB.append(next);
        shortStringSB.append((counter >= 1) ? counter + 1 : "");

        System.out.printf("%s -> %s%n", longString, shortStringSB);
        }

/** Задача 3. Напишите метод, который вернет содержимое текущей папки в виде массива строк.
 * Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
 * Обработайте ошибки c помощью try-catсh конструкции. В случае возникновения исключения,
 * оно должно записаться в лог-файл.*/

        private static void ex5(String pathDir) {
            File file = new File(pathDir);
            if (!file.isDirectory()) {
                return;
            }
             String[] dirListNames = file.list();

            StringBuilder sb = new StringBuilder();
            for (String fileName : dirListNames) {
                sb.append(fileName).append(System.lineSeparator());
            } //System.out.println(sb); вывод на экран

            try(PrintWriter pw = new PrintWriter("C:\\Users\\Anika\\Desktop\\lessonjava\\untitled\\src\\main\\java\\resources\\output.txt")) {
                pw.print(sb);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }}




