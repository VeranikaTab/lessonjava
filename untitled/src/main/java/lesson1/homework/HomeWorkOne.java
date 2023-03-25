package lesson1.homework;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkOne {
    public static void main(String[] args) {
        System.out.println("""
                Список задач:
                Задача 1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
              
                Задача 2. Дан массив nums = [3,2,2,3] и число val = 3.
                Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
                Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
                а остальные - равны ему.
          
                Задача 3. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
                "Доброе утро, <Имя>!", если время от 05:00 до 11:59
                "Добрый день, <Имя>!", если время от 12:00 до 17:59;
                "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
                "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
                """);

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер задачи  ");
        String number = scan.nextLine();
        switch (number) {
            case "1" -> ArrMinMax();
            case "2" -> ArrShiftToEndElement();
            case "3" -> GreetingFromCurrentTime();
        }}

    public static void ArrMinMax() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 50);
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Максимальное значение: ");
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.print("Минимальное значение: ");
        System.out.println(Arrays.stream(arr).min().getAsInt());
//        int max = 0;
//        int min = 1000000;
//        for (int num : arr) {
//            if (num > max) {
//                max = num;
//            }
//            if (num < min) {
//                min = num;
//            }

        //System.out.printf("Минимальное значение: %d\n", min);
        //System.out.printf("Максимальное значение: %d\n", max);}
    }


    public static void ArrShiftToEndElement () {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.print(Arrays.toString(nums));
        int val = 3;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            if (nums[leftIndex] == val & nums[rightIndex] != val) {
                int c = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = c;
                leftIndex++;
                rightIndex--;
            } else if (nums[leftIndex] != val) {
                leftIndex++;
            } else if (nums[rightIndex] == val) {
                rightIndex--;
            }
        }
        int[] newArr = nums;
        System.out.println();
        System.out.printf(Arrays.toString(newArr));
    }

    public static void GreetingFromCurrentTime () {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите имя: ");
        String name = scanner.nextLine();
        scanner.close();
        int nowTime = LocalTime.now().getHour();

        if (nowTime == 23 || nowTime < 5) {
            System.out.println("Доброй ночи," +name+"!");
        }else if (nowTime < 12) {
            System.out.println("Доброе утро," +name+"!");
        }else if (nowTime < 18) {
            System.out.println("Добрый день, " +name+"!");
        }else {
            System.out.println("Добрый вечер," +name+"!");
        }
    }
}
