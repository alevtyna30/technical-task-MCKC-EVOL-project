import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleCalculator implements Calculator {

    private final int scale;

    public SimpleCalculator(int scale) {
        this.scale = scale;
    }

    @Override
    public BigDecimal add(int a, int b) {
        BigDecimal bigA = new BigDecimal(a);
        BigDecimal bigB = new BigDecimal(b);
        return bigA.add(bigB);
    }

    @Override
    public BigDecimal subtract(int a, int b) {
        BigDecimal bigA = new BigDecimal(a);
        BigDecimal bigB = new BigDecimal(b);
        return bigA.subtract(bigB);
    }

    @Override
    public BigDecimal multiply(int a, int b) {
        BigDecimal bigA = new BigDecimal(a);
        BigDecimal bigB = new BigDecimal(b);
        return bigA.multiply(bigB);
    }

    @Override
    public BigDecimal divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        BigDecimal bigA = new BigDecimal(a);
        BigDecimal bigB = new BigDecimal(b);
        return bigA.divide(bigB, scale, RoundingMode.HALF_UP);
    }

}
