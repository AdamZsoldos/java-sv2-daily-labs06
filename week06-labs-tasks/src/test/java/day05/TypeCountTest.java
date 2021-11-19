package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeCountTest {

    TypeCount typeCount;

    @BeforeEach
    void setUp() {
        typeCount = new TypeCount(Type.FISH);
    }

    @Test
    void createTest() {
        assertSame(Type.FISH, typeCount.getType());
        assertEquals(1, typeCount.getCount());
    }

    @Test
    void incrementTest() {
        typeCount.increment();
        assertEquals(2, typeCount.getCount());
    }
}
