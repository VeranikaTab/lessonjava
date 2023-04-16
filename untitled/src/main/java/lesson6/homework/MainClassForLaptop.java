package lesson6.homework;

import java.util.*;

public class MainClassForLaptop {

    /** 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    2. Создать множество ноутбуков (ArrayList).
    3. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. Например,
       спросить у пользователя минимальный размер оперативной памяти или конкретный цвет.
       Выводить только те ноутбуки, что соответствуют условию*/

    public static int userInput(String message){
        Scanner sc = new Scanner(System.in);
        int inputmessage;
        while (true){
            System.out.println(message);
            try{
                inputmessage = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод!");
            }
        }
        return inputmessage;
    }
    public static String userSInput(String message){

        Scanner sc = new Scanner(System.in);
        String inputmessage;
        while (true){
            System.out.println(message);
            try{
                inputmessage = sc.nextLine();
                break;
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод!");
            }
        }
        return inputmessage;
    }

    public static void main(String[] args) {


        Laptop laptop1 = new Laptop(1);
        laptop1.brand = "MSI";
        laptop1.model = "Katana GF76 11UE-426RU";
        laptop1.color = "Black";
        laptop1.screenSize = "17";
        laptop1.modelCPU = "Intel";
        laptop1.modelGPU = "NVIDIA GeForce RTX 3060 6GB";
        laptop1.amountRAM = "6";
        laptop1.ssdVolume = "512";

        Laptop laptop2 = new Laptop(2);
        laptop2.brand = "Honor";
        laptop2.model = "MagicBook 16 R5";
        laptop2.color = "Black";
        laptop2.screenSize = "16";
        laptop2.modelCPU = "AMD";
        laptop2.modelGPU = "AMD Radeon Graphics";
        laptop2.amountRAM = "16";
        laptop2.ssdVolume = "512";

        Laptop laptop3 = new Laptop(3);
        laptop3.brand = "ASUS";
        laptop3.model = "TUF Gaming A15";
        laptop3.color = "dark grey";
        laptop3.screenSize = "15";
        laptop3.modelCPU = "AMD";
        laptop3.modelGPU = "NVIDIA GeForce GTX 1650 4GB";
        laptop3.amountRAM = "8";
        laptop3.ssdVolume = "512";

        Laptop laptop4 = new Laptop(4);
        laptop4.brand = "Xiaomi";
        laptop4.model = "RedmiBook 15";
        laptop4.color = "Silver";
        laptop4.screenSize = "15";
        laptop4.modelCPU = "Intel";
        laptop4.modelGPU = "Intel UHD Graphics";
        laptop4.amountRAM = "8";
        laptop4.ssdVolume = "256";

        Laptop laptop5 = new Laptop(5);
        laptop5.brand = "HUAWEI";
        laptop5.model = "MateBook X Pro MRGF-X";
        laptop5.color = "Silver";
        laptop5.screenSize = "14";
        laptop5.modelCPU = "Intel";
        laptop5.modelGPU = "Intel Iris Xe Graphics";
        laptop5.amountRAM = "12";
        laptop5.ssdVolume = "1"+"Тб";

        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(laptop1);
        laptopList.add(laptop2);
        laptopList.add(laptop3);
        laptopList.add(laptop4);
        laptopList.add(laptop5);

        HashSet<Laptop> hashLaptop = new HashSet(laptopList);

        while (true) {
        int num = userInput("Сортировка по: \n \n 1 - бренду, \n 2 - оперативной памяти," +
                " \n 3 - размеру жесткого диска, \n 4 - модели процессора, \n 5 - по цвету," +
                " \n 6 - диагонали, \n 7 - весь список , \n \n для завершения работы нажмите - 0 ");

        if (num == 7){
            for (Laptop laptop: hashLaptop) {
                laptop.printInfo();
                System.out.println();
            }
        }

        else if (num == 1){
            String podNumbers = userSInput("Введите бренд (MSI, Honor, ASUS, Xiaomi, HUAWEI)");
            for (Laptop brand : hashLaptop) {
                if (brand.getBrand().equalsIgnoreCase(podNumbers)) {
                    System.out.println(brand.printInfo());
                }
            }
        }

        else if (num == 2){
            String podNumbers = userSInput("Введите размер оперативной памяти (8, 12, 16): ");
            for (Laptop amountRAM : hashLaptop) {
                if (amountRAM.getAmountRAM().equalsIgnoreCase(podNumbers)) {
                    System.out.println(amountRAM.printInfo());
                }
            }
        }

        else if (num == 3){
            String podNumbers = userSInput("Введите размер жесткого диска (256, 512, 1): ");
            for (Laptop ssdVolume : hashLaptop) {
                if (ssdVolume.getSsdVolume().equalsIgnoreCase(podNumbers)) {
                    System.out.println(ssdVolume.printInfo());
                }
            }
        }

        else if (num == 4){
            String podNumbers = userSInput("Введите модель процессора (Intel, AMD): ");
            for (Laptop modelCPU : hashLaptop) {
                if (modelCPU.getModelCPU().equalsIgnoreCase(podNumbers)) {
                    System.out.println(modelCPU.printInfo());
                }
            }
        }

        else if (num == 5){
            String podNumbers = userSInput("Введите цвет (Black, dark grey, Silver) : ");
            for (Laptop color : hashLaptop) {
                if (color.getColor().equalsIgnoreCase(podNumbers)) {
                    System.out.println(color.printInfo());
                }
            }
        }
        else if (num == 6){
            String podNumbers = userSInput("Введите диагональ (14, 15, 16, 17) :");
            for (Laptop screenSize : hashLaptop) {
                if (screenSize.getScreenSize().equalsIgnoreCase(podNumbers)) {
                    System.out.println(screenSize.printInfo());
                }
            }
        }
        else if (num == 0){
            break;
                }
            }
        System.out.println();
        }
}

