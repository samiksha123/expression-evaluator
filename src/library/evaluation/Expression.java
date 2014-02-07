package library.evaluation;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private Double value;
    private List<Expression> operands = new ArrayList<>();
    private List<String> operators;

    public Expression(Double value) {
        this.value = value;
    }

    public Expression() {
    }

    public double evaluateExpression(String expr) throws Exception {
        String expression = new Parser(expr).replaceExpression(expr);
        expression = expression.replace("--", "");
        if (expression.contains("(")) {
            String res = evaluateWithBrackets(expression);
            return new Expression().evaluateExpression(res);
        }
        if (!expression.contains(" ")) return Double.parseDouble(expression);
        String[] data = expression.split(" ");
        this.operators = getOperators(data);
        this.operands = getOperands(data);
        List<Double> values = new ArrayList<>();
        for (Expression sd : operands) {
            values.add(sd.value);
        }

        double result = evaluate(values, operators);
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

    private double evaluate(List<Double> operands, List<String> operators) throws Exception {
        Operators calculator = new Operators();
        double result = calculator.operate(operands.get(0), operators.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = calculator.operate(result, operators.get(i), operands.get(i + 1));
        }
        return result;
    }

    private List<String> getOperators(String[] data) {
        List<String> operators = new ArrayList<String>();
        for (String s : data) {
            try {
                Double.parseDouble(s);
            } catch (Exception ex) {
                operators.add(s);
            }
        }

        return operators;
    }

    private List<Expression> getOperands(String[] data) {
        List<Expression> expressions = new ArrayList<>();
        for (String s : data) {
            try {
                double v = Double.parseDouble(s);
                expressions.add(new Expression(v));
            } catch (Exception ex) {
                // ignore
            }
        }

        return expressions;
    }


}
