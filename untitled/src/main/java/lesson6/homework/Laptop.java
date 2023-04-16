package lesson6.homework;


public class Laptop {
    private final int id;
    String brand;
    String model;
    String color;
    String screenSize;
    String modelCPU;
    String modelGPU;
    String amountRAM;
    String ssdVolume;


    public Laptop(int id) {
        this.id = id;
    }
    public Laptop(int id, String brand, String model, String color, String screenSize, String modelCPU, String modelGPU, String amountRAM, String ssdVolume) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.screenSize = screenSize;
        this.modelCPU = modelCPU;
        this.modelGPU = modelGPU;
        this.amountRAM = amountRAM;
        this.ssdVolume = ssdVolume;
    }


    public String printInfo() {
        System.out.printf("id: %s, brand: %s, model: %s, color: %s, screenSize: %s '', modelCPU: %s, modelGPU: %s, amountRAM: %s, ssdVolume: %s", id, brand, model, color, screenSize, modelCPU, modelGPU, amountRAM, ssdVolume);
        return ".";
    }


    public String getBrand() {
        return brand;
    }


    public String getAmountRAM() {
        return amountRAM;
    }

    public String getSsdVolume() {
        return ssdVolume;
    }

    public String getModelCPU() {
        return modelCPU;
    }

    public String getColor() {
        return color;
    }

    public String getScreenSize() {
        return screenSize;
    }








}
