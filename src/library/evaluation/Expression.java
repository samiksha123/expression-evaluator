package library.evaluation;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private Double value;
    private List<Expression> expressions = new ArrayList<>();
    private List<String> operators;

    public Expression() {
    }

    public Expression(Double value) {
        this.value = value;
    }

    public Expression(List<Expression> expressions, List<String> operators){
        this.expressions = expressions;
        this.operators = operators;
    }

    public Expression parse(String expr) throws Exception {
        String cleanedExpression = clean(expr);

        if (cleanedExpression.contains("(")) {
            String res = evaluateWithBrackets(cleanedExpression);
            return new Expression().parse(res);
        }

        if (!cleanedExpression.contains(" "))
            return new Expression(Double.parseDouble(cleanedExpression));

        String[] data = cleanedExpression.split(" ");
        return new Expression(getOperands(data), getOperators(data)).evaluate();
    }


    private String clean(String expr) {
        return new Parser(expr).replaceExpression(expr).replace("--", "");
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
        sb.replace(startIndex, endIndex + 1, String.valueOf(parse(expressionInBrackets).value));
        return sb.toString();
    }

    private Expression evaluate(){
        Operators calculator = new Operators();
        double result = calculator.operate(expressions.get(0).getValue(),
                operators.get(0), expressions.get(1).getValue());
        for (int i = 1; i < operators.size(); i++) {
            result = calculator.operate(result, operators.get(i),
                    expressions.get(i + 1).getValue());
        }
        this.value = result;
        return this;
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

    public Double getValue() {
        return (value!=null)? value: this.evaluate().getValue() ;
    }
}
