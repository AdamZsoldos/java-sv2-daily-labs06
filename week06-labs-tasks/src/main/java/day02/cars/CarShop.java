package day02.cars;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private final String name;
    private final int priceLimit;
    private final List<Car> carsForSell = new ArrayList<>();

    public CarShop(String name, int priceLimit) {
        this.name = name;
        this.priceLimit = priceLimit;
    }

    public String getName() {
        return name;
    }

    public int getPriceLimit() {
        return priceLimit;
    }

    public List<Car> getCarsForSell() {
        return carsForSell;
    }

    public boolean addCar(Car car) {
        if (car.getPrice() > priceLimit) { return false; }
        carsForSell.add(car);
        return true;
    }

    public int sumCarPrice() {
        int sum = 0;
        for (Car car : carsForSell) {
            sum += car.getPrice();
        }
        return sum;
    }

    public int numberOfCarsCheaperThan(int price) {
        int result = 0;
        for (Car car : carsForSell) {
            if (car.getPrice() <= price) {
                result++;
            }
        }
        return result;
    }

    public List<Car> carsWithBrand(String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : carsForSell) {
            if (car.getBrand().equals(brand)) {
                result.add(car);
            }
        }
        return result;
    }
}
