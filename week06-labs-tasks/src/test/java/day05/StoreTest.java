package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store;

    @BeforeEach
    void setUp() {
        store = new Store();
        store.addProduct(new Product("milk", Type.DAIRY, 10.0));
        store.addProduct(new Product("bread", Type.BAKERY, 12.0));
        store.addProduct(new Product("peas", Type.FROZEN, 13.0));
        store.addProduct(new Product("cheese", Type.DAIRY, 11.0));
    }

    @Test
    void addProductTest() {
        assertEquals(4, store.getProducts().size());
    }

    @Test
    void numberOfProductsPerTypeTest() {
        List<TypeCount> typeCountList = store.numberOfProductsPerType();
        assertEquals(3, typeCountList.size());
        assertSame(Type.DAIRY, typeCountList.get(0).getType());
        assertSame(Type.BAKERY, typeCountList.get(1).getType());
        assertSame(Type.FROZEN, typeCountList.get(2).getType());
        assertEquals(2, typeCountList.get(0).getCount());
        assertEquals(1, typeCountList.get(1).getCount());
        assertEquals(1, typeCountList.get(2).getCount());
    }
}
