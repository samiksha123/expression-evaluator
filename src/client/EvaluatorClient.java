package client;

import library.evaluation.Expression;

public class EvaluatorClient {
    public static void main(String[] args) throws Exception {
        Expression e = new Expression();
        System.out.println(e.parse(args[0]));
    }
}
