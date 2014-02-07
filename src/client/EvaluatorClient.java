package client;

import library.evaluation.Expression;
import library.evaluation.Parser;

public class EvaluatorClient {
    public static void main(String[] args) throws Exception {
        Expression e = new Expression();
        System.out.println(new Parser().parse(args[0]).getValue());
    }
}
