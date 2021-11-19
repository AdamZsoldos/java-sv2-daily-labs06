package day05;

public class Product {

    private final String name;
    private final Type type;
    private final double price;

    public Product(String name, Type type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
