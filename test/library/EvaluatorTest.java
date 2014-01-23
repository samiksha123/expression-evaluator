package library;

import static org.junit.Assert.assertEquals;

public class EvaluatorTest extends Evaluator {
    @org.junit.Test
    public void testEvaluate() throws Exception {
        String expression = "2 + 3";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,5);
    }
    @org.junit.Test
    public void test_for_adding_two_numbers() throws Exception {
        String expression = "45 + 10";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,55);
    }
    @org.junit.Test
    public void test_if_only_one_operand_is_given() throws Exception {
        String expression = "22";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,22);
    }
    @org.junit.Test
    public void test_for_subtraction_of_two_numbers() throws Exception {
        String expression = "40 - 10";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,30);
    }
    @org.junit.Test
    public void test_for_multiplication_of_two_numbers() throws Exception {
        String expression = "4 * 10";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,40);
    }
    @org.junit.Test
    public void test_for_division_of_two_numbers() throws Exception {
        String expression = "22 / 3";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,7);
    }
    @org.junit.Test
    public void test_for_calculating_power_of_two_numbers() throws Exception {
        String expression = "2 ^ 3";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,8);
    }
    @org.junit.Test
    public void test_for_evaluating_multiple_operations() throws Exception {
        String expression = "1 + 3 * 2";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,8);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations() throws Exception {
        String expression = "4 + 5 * 2 / 3 ^ 2 - 3";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,33);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_brackets() throws Exception {
        String expression = "4 + (5 * 2) / 2";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,7);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_only_brackets() throws Exception {
        String expression = "(5 * 2 - 5 ^ 2)";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,25);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_multiple_brackets() throws Exception {
        String expression = "4 + (5 * 2) / 2 - (2 / 2)";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,6);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_brackets_inside_brackets() throws Exception {
        String expression = "4 + (5 * 2 + (3 + 1) - 2)";
        Evaluator e = new Evaluator();
        int res = e.evaluateExpression(expression);
        assertEquals(res,16);
    }
}