package library.operations;


/**
 * Created by samiksha on 2/7/14.
 */
public class Exponential implements Operator {
    @Override
    public double calculate(double num1, double num2) {
        return Math.pow(num1,num2);
    }
}
