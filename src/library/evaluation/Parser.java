package library.evaluation;

import java.util.List;

/**
 *resolve (a expression) into its component parts.
 */
public class Parser {

    public static String format(String expression) {
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

    static void parse(String expression, List<String> operators, List<Double> operands) {
        String[] data = expression.split(" ");
        for (String s : data) {
            try {
                Double number = Double.parseDouble(s);
                operands.add(number);
            } catch (Exception ex) {
                operators.add(s);
            }
        }
    }
}
