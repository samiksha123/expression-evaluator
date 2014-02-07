package library.evaluation;

import java.util.ArrayList;
import java.util.List;

import library.operations.Operation;

public class Expression {


    public double evaluateExpression(String expr) throws Exception {
        String expression = new Parser(expr).replaceExpression(expr);
        expression = expression.replace("--", "");
        if (expression.contains("(")) {
            String res = evaluateWithBrackets(expression);
            return evaluateExpression(res);
        }
        if (!expression.contains(" ")) return Double.parseDouble(expression);
        String[] data = expression.split(" ");
        List<Double> operands = new ArrayList<Double>();
        List<String> operators = getOperators(data, operands);
        double result = evaluateMultipleOperations(operands, operators);
        return result;
    }

    private String evaluateWithBrackets(String expression) throws Exception {
        StringBuffer sb = new StringBuffer(expression);
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') startIndex = i;
            else if (expression.charAt(i) == ')') {
                endIndex = i;
                break;
            }
        }
        String expressionInBrackets = expression.substring(startIndex + 1, endIndex);
        double res = evaluateExpression(expressionInBrackets);
        sb.replace(startIndex, endIndex + 1, Double.toString(res));
        return sb.toString();
    }

    private double evaluateMultipleOperations(List<Double> operands, List<String> operators) throws Exception {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(operands.get(0), operators.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = calculator.calculate(result, operators.get(i), operands.get(i + 1));
        }
        return result;
    }

    private List<String> getOperators(String[] data, List<Double> operands) {
        List<String> operators = new ArrayList<String>();
        for (String s : data) {
            try {
                Double number = Double.parseDouble(s);
                operands.add(number);
            } catch (Exception ex) {
                operators.add(s);
            }
        }

        return operators;
    }
}
