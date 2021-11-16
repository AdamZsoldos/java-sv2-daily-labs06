package day02.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectNumbersTest {

    PerfectNumbers perfectNumbers;

    @BeforeEach
    void setUp() {
        perfectNumbers = new PerfectNumbers();
    }

    @Test
    void testIsPerfectNumber() {
        assertTrue(perfectNumbers.isPerfectNumber(6));
        assertTrue(perfectNumbers.isPerfectNumber(8128));
        assertFalse(perfectNumbers.isPerfectNumber(7246));
        assertFalse(perfectNumbers.isPerfectNumber(9));
    }
}
