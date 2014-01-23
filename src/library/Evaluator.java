package library;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

    private double evaluate(double num1, String operator, double num2) {
        double result = 0.0;
        if (operator.equals("+")) result = num1 + num2;
        if (operator.equals("-")) result = num1 - num2;
        if (operator.equals("*")) result = num1 * num2;
        if (operator.equals("/")) result = num1 / num2;
        if (operator.equals("^")) result = (int) Math.pow(num1, num2);
        return result;
    }
    public double evaluateExpression(String expression) throws Exception {
        String exp = replaceExpression(expression);
        if (!exp.contains(" ")) return Double.parseDouble(exp);
        if (exp.contains("(")) {
            String res = evaluateWithBrackets(exp);
            return evaluateExpression(res);
        }
        String[] data = exp.split(" ");
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
        Evaluator e = new Evaluator();
        double result = e.evaluate(operands.get(0), operators.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = e.evaluate(result, operators.get(i), operands.get(i + 1));
        }
        return result;
    }

    private List<String> getOperators(String[] data, List<Double> operands) {
        List<String> operators = new ArrayList<String>();
        List list = new ArrayList();
        for (String s : data) {
            try {
                Double number = Double.parseDouble(s);
                operands.add(number);
            } catch (Exception ex) {
                operators.add(s);
            }
        }
        if (operands.size() - 1 == operators.size())
            return operators;
        list.add("wrong input");
        return list;
    }
    public String replaceExpression(String expression) {
        return expression.trim().replaceAll(" +", "")
                .replaceAll("\\+", " + ")
                .replaceAll("\\-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\(", "(")
                .replaceAll("\\)", ")")
                .replaceAll("\\^", " ^ ")
                .replaceFirst("^ - ", "-");
    }
}