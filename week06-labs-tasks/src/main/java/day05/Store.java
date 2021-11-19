package day05;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<TypeCount> numberOfProductsPerType() {
        List<TypeCount> result = new ArrayList<>();
        for (Product product : products) {
            incrementProductType(product, result);
        }
        return result;
    }

    private void incrementProductType(Product product, List<TypeCount> typeCountList) {
        for (TypeCount typeCount : typeCountList) {
            if (typeCount.getType() == product.getType()) {
                typeCount.increment();
                return;
            }
        }
        typeCountList.add(new TypeCount(product.getType()));
    }
}
