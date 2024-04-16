import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleCalculatorTests {

    public static final String MAX_INTEGER_MULTIPLY_TWO_MAX_VALUE = "4611686014132420609";
    public static final int SCALE = 5;

    private Calculator calculator = new SimpleCalculator(SCALE);

    @Test
    public void testAdd() {
        assertEquals(new BigDecimal(5), calculator.add(2, 3));
        assertEquals(new BigDecimal(-1), calculator.add(-2, 1));
        assertEquals(new BigDecimal(0), calculator.add(0, 0));
        assertEquals(new BigDecimal("4294967294"), calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testSubtract() {
        assertEquals(new BigDecimal(1), calculator.subtract(3, 2));
        assertEquals(new BigDecimal(-3), calculator.subtract(0, 3));
        assertEquals(new BigDecimal(0), calculator.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(new BigDecimal(6), calculator.multiply(2, 3));
        assertEquals(new BigDecimal(0), calculator.multiply(0, 5));
        assertEquals(new BigDecimal(-8), calculator.multiply(-2, 4));
        assertEquals(new BigDecimal(MAX_INTEGER_MULTIPLY_TWO_MAX_VALUE), calculator.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testDivide() {
        assertEquals(new BigDecimal(2).setScale(SCALE, RoundingMode.HALF_UP), calculator.divide(6, 3));
        assertEquals(new BigDecimal(0).setScale(SCALE, RoundingMode.HALF_UP), calculator.divide(0, 5));
        assertEquals(new BigDecimal("2.66667"), calculator.divide(8, 3));
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
    }
}
