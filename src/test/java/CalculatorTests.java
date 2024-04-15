import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {
    Calculator calculator = new SimpleCalculator();


    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(4294967294.0, calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-3, calculator.subtract(0, 3));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(0, 5));
        assertEquals(-8, calculator.multiply(-2, 4));


    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(0, calculator.divide(0, 5));
        assertEquals(2.6666666666666665, calculator.divide(8, 3));
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
    }

}
