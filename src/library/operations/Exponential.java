package library.operations;

import library.operations.Operation;

/**
 * Created by samiksha on 2/7/14.
 */
public class Exponential implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        return Math.pow(num1,num2);
    }
}
