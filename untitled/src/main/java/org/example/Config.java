package org.example;

public class Config {
    private String name;
    private String cpu;
    private String gpu;
    private String storage;
    private int ram;
    private double price;

    public Config(String name, String cpu, String gpu, String storage, int ram, double price) {
        this.name = name;
        this.cpu = cpu;
        this.gpu = gpu;
        this.storage = storage;
        this.ram = ram;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCpu() { return cpu; }
    public String getGpu() { return gpu; }
    public String getStorage() { return storage; }
    public int getRam() { return ram; }
    public double getPrice() { return price; }
}

