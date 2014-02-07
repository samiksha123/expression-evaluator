package library.evaluation;

import java.util.List;

/**
 *resolve (a expression as String) into its component parts.
 */
public class Parser {
    private String text;

    public Parser(String text) {
        this.text = text;
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
