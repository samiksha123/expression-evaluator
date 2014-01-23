package library;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

    private int evaluate(int num1, String operator, int num2) {
        int result = 0;
        if (operator.equals("+")) result = num1 + num2;
        if (operator.equals("-")) result = num1 - num2;
        if (operator.equals("*")) result = num1 * num2;
        if (operator.equals("/")) result = num1 / num2;
        if (operator.equals("^")) result = (int) Math.pow(num1, num2);
        return result;
    }

    public int evaluateExpression(String expression) throws Exception {
        if (!expression.contains(" ")) return Integer.parseInt(expression);
        String[] data = expression.split(" ");
        int result;
        if (expression.contains("(")){
            String res = evaluateWithBrackets(expression);
            return evaluateExpression(res);
        }
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = getOperators(data, operands);
        result = evaluateMultipleOperations(operands, operators);
        return result;
    }

    private String evaluateWithBrackets(String expression) throws Exception {
        StringBuffer sb = new StringBuffer(expression);
        int endIndex = expression.indexOf(")");
        int startIndex = expression.indexOf("(");
        String expressionInBrackets = expression.substring(startIndex + 1, endIndex);
        int res = evaluateExpression(expressionInBrackets);
        sb.replace(startIndex, endIndex + 1, Integer.toString(res));
        return sb.toString();
    }


    private int evaluateMultipleOperations(List<Integer> operands, List<String> operators) throws Exception {
        Evaluator e = new Evaluator();
        int result = e.evaluate(operands.get(0), operators.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = e.evaluate(result, operators.get(i), operands.get(i + 1));
        }
        return result;
    }

    private List<String> getOperators(String[] data, List<Integer> operands) {
        List<String> operators = new ArrayList<String>();
        for (String s : data) {
            try {
                int number = Integer.parseInt(s);
                operands.add(number);
            } catch (Exception ex) {
                operators.add(s);
            }
        }
        return operators;
    }
}