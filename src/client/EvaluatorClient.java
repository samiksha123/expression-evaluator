package client;

import library.evaluation.Evaluator;

public class EvaluatorClient {
    public static void main(String[] args) throws Exception {
        Evaluator e = new Evaluator();
        System.out.println(e.evaluateExpression(args[0]));
    }
}
