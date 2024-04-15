public class SimpleCalculator implements Calculator {

    public double add(int a, int b) {
        return (double) a + b;
    }

    public double subtract(int a, int b) {
        return a - b;
    }

    public double multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        return (double) a / b;
    }
}
