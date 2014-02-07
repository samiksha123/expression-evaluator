package library.evaluation;

import java.util.List;

/**
 *resolve (a expression as String) into its component parts.
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

}
