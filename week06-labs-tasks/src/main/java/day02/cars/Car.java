package day02.cars;

public class Car {

    private final String brand;
    private final double engineCapacity;
    private final Color color;
    private int price;

    public Car(String brand, double engineCapacity, Color color, int price) {
        this.brand = brand;
        this.engineCapacity = engineCapacity;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public void decreasePrice(int percent) {
        price = (int) (price * (100 - percent) * 0.01);
    }
}
