package library.operations;

/**
 * Created by samiksha on 2/7/14.
 */
public class Division implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }
}
