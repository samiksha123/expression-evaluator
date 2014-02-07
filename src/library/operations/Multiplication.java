package library.operations;

/**
 * Created by samiksha on 2/7/14.
 */
public class Multiplication implements Operator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}
