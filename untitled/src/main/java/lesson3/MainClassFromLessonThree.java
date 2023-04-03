package lesson3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class MainClassFromLessonThree {
    public static void main(String[] args) {
   // ex0();
    //ex1();
    ex2();
}
/** Задание 0. Даны следующие строки, сравнить их с помощью == и метода equals()
 *  класса Object */
    private static void ex0() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        System.out.println(s1 == s5);
        System.out.println(s1.equals(s5));
    }
/**Задание №1
 Заполнить список десятью случайными числами.
 Отсортировать список методом sort() и вывести его на экран.
 */
    private static void ex1() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(20)); //0 - 19
        }

        System.out.println(list);
        Collections.sort(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
/**Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
 Вывести название каждой планеты и количество его повторений в списке.
 */
//        "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluton"
    public static void ex2() {
        List<String> planetsNames = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter",
                "Saturn", "Uranus", "Neptun", "Pluton");
        Random random = new Random();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            list.add(planetsNames.get(random.nextInt(9)));
        }

        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(list.get(i+1))) {
                count++;
            }else{
                sb.append(list.get(i))
                        .append(": ")
                        .append(count)
                        .append("; ");
                count = 1;
            }
        }
        sb.append(list.get(list.size() - 1)).append(": ").append(count).append(".");

        System.out.println(sb);
    }

}
