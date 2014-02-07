package library.evaluation;

import library.operations.*;

import java.util.HashMap;
import java.util.Map;

/**
 *Calculate result based on operator
 */
public class Calculator {
    Map<String, Operation> operators = new HashMap();

    public Calculator() {
        operators.put("+", new Addition());
        operators.put("-", new Subtraction());
        operators.put("*", new Multiplication());
        operators.put("/", new Division());
        operators.put("^", new Exponential());
    }

    protected double calculate(double num1, String operator, double num2) {
        if(operators.containsKey(operator))
            return operators.get(operator).calculate(num1,num2);
        return 0;
    }
}
