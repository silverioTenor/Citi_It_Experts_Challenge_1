package main.models;

public class Vehicle {

    private String brand;

    private String model;

    private double engine;

    private String color;

    private double price;

    private String category;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        String print = "";
        print += "Marca: " + ((brand != null) ? brand : "nao preenchido");
        print += "\nModelo: " + ((model != null) ? model : "nao preenchido");
        print += "\nMotor: " + engine;
        print += "\nCor: " + ((color != null) ? color : "nao preenchido");
        print += "\nPreco: R$ " + price;
        print += "\nCategoria: " + ((category != null) ? category : "nao preenchido");

        return print;
    }
}
