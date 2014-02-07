package library.evaluation;

import java.util.ArrayList;
import java.util.List;

/**
 *resolve (a expression as String) into its component parts.
 */
public class Parser {

    public Expression parse(String expr) throws Exception {
        String cleanedExpression = replaceExpression(expr).replace("--", "");

        if (cleanedExpression.contains("(")) {
            StringBuffer sb = new StringBuffer(cleanedExpression);
            int startIndex = 0, endIndex = 0;
            for (int i = 0; i < cleanedExpression.length(); i++) {
                if (cleanedExpression.charAt(i) == '(') startIndex = i;
                else if (cleanedExpression.charAt(i) == ')') {
                    endIndex = i;
                    break;
                }
            }
            String expressionInBrackets = cleanedExpression.substring(startIndex + 1, endIndex);
            sb.replace(startIndex, endIndex + 1,
                    String.valueOf(parse(expressionInBrackets).getValue()));
            String res = sb.toString();
            return parse(res);
        }

        if (!cleanedExpression.contains(" "))
            return new Expression(Double.parseDouble(cleanedExpression));

        String[] data = cleanedExpression.split(" ");

        List<String> operators1 = new ArrayList<String>();
        List<Expression> expressions1 = new ArrayList<>();

        for (String s : data) {
            try {
                double v = Double.parseDouble(s);
                expressions1.add(new Expression(v));
            } catch (Exception ex) {
                operators1.add(s);
            }
        }

        return new Expression(expressions1, operators1).evaluate();
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
                .replaceAll("  - ", " -")
                .replaceFirst("^ - ", "-");
    }

}
