package library.evaluation;

import library.operations.*;

import java.util.HashMap;
import java.util.Map;

/**
 *Calculate result based on operator
 */
public class Operators {
    Map<String, Operator> operators = new HashMap();

    public Operators() {
        operators.put("+", new Addition());
        operators.put("-", new Subtraction());
        operators.put("*", new Multiplication());
        operators.put("/", new Division());
        operators.put("^", new Exponential());
    }

    protected double operate(double num1, String operator, double num2) {
        if(operators.containsKey(operator))
            return operators.get(operator).calculate(num1,num2);
        return 0;
    }
}
