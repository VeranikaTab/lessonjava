package lesson1;
/**
 * Задача 1. Написать программу, которая запросит пользователя ввести
 * <Имя> в консоли.
 * Получит введеную строку и выведет в консоль сообщение
 * "Привет, <Имя>!"
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        inputNameAndPrint(); // вызываем первую задачу
        int n = getRandomArrMaxCount(10);
        System.out.println(n);
    }
    public static void inputNameAndPrint() {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите имя, ");
        String name = scanner.nextLine();
        System.out.printf("Привет, %s!%n", name); //%n - универсальный перенос
        scanner.close();// не обязательно
    }

    /**
     * Задача 2. Данн массив двоичных чисел, например [1,1,0,1,1,1], вывести
     * максимальное количество подряд идущих 1.
     *
     * @return
     */
    public static int getRandomArrMaxCount(int size) {
        //int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2); //0-1 (генерируем от 0 до 1)
//          arr[i] = random.nextInt(3, 10); //3-9 (если указываем от и до-1) */
        }
        int count = 0;
        int maxCount = 0;
/*        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            System.out.println(num);
        }*/  // этот код = коду ниже!. просто он более развернут!
        for (int num : arr) {
            if (num == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(Arrays.toString(arr)); //метод вывода массива в строку
        return maxCount; // чтобы вернуть значение, необх в начале указать вместо войд инт.
    }
}
