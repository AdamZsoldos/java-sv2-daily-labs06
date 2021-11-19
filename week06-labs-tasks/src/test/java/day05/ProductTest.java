package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void createTest() {
        Product product = new Product("milk", Type.DAIRY, 10.0);
        assertEquals("milk", product.getName());
        assertSame(Type.DAIRY, product.getType());
        assertEquals(10.0, product.getPrice(), 0.05);
    }
}
