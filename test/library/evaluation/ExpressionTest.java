package library.evaluation;

//import static org.junit.Assert.assertEquals;
import library.evaluation.Expression;

import static junit.framework.Assert.assertEquals;

public class ExpressionTest  {
    @org.junit.Test
    public void testEvaluate() throws Exception {
        String expression = "2 + 3";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,5.0);
    }
    @org.junit.Test
    public void test_for_adding_two_numbers() throws Exception {
        String expression = "45 + 10";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,55.0);
    }
    @org.junit.Test
    public void test_if_only_one_operand_is_given() throws Exception {
        String expression = "22";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,22.0);
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void test_if_only_one_operand_and_one_operator_is_given() throws Exception {
        String expression = "22+";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,22.0);
    }
    @org.junit.Test
    public void test_for_subtraction_of_two_numbers() throws Exception {
        String expression = "40 - 10";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,30.0);
    }
    @org.junit.Test
    public void test_for_multiplication_of_two_numbers() throws Exception {
        String expression = "4 * 10";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,40.0);
    }
    @org.junit.Test
    public void test_for_subtraction_of_negative_numbers() throws Exception {
        String expression = "-1-1";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,-2.0);
    }
    @org.junit.Test
    public void test_for_division_of_two_numbers() throws Exception {
        String expression = "22 / 3";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        double expected = 7.333333333333333;
        assertEquals(res,expected);
    }
    @org.junit.Test
    public void test_for_calculating_power_of_two_numbers() throws Exception {
        String expression = "2 ^ 3";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,8.0);
    }
    @org.junit.Test
    public void test_for_evaluating_multiple_operations() throws Exception {
        String expression = "1 + 3 * 2";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,8.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations() throws Exception {
        String expression = "4 + 5 * 2 / 3 ^ 2 - 3";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,33.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_brackets() throws Exception {
        String expression = "4 + (5 * 2) / 2";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,7.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_only_brackets() throws Exception {
        String expression = "(5 * 2 - 5 ^ 2)";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,25.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_multiple_brackets() throws Exception {
        String expression = "4 + (5 * 2) / 2 - (2 / 2)";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,6.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_brackets_inside_brackets() throws Exception {
        String expression = "4 + (5 * 2 + (3 + 1) - 2)";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,16.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_brackets_and_spaces_inside_brackets() throws Exception {
        String expression = "4 + ( 5*           2 +( 3 + 1))";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        assertEquals(res,18.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_of_float() throws Exception {
        String expression = "4.20 + 3.50";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        double expected = 7.70;
        assertEquals(res,expected);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_for_negative() throws Exception {
        String expression = "-4.20 + 2.50";
        Expression e = new Expression();
        double res = e.evaluateExpression(expression).value;
        double expected = -1.7000000000000002;
        assertEquals(res,expected);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_space_handling() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("4.20+3.50").value;
        assertEquals(res,7.70);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_space_handling2() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("1+ 3   * 4 -3").value;
        assertEquals(res,13.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_with_handling3() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression( "1 + -2").value;
        assertEquals(res,-1.0);
    }
    @org.junit.Test
    public void test_for_evaluate_exponential() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("-1 ^ -4").value;
        assertEquals(res,1.0);
    }
    @org.junit.Test
    public void test_for_evaluate_exponential_2() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("-1 ^ -1").value;
        assertEquals(res,-1.0);
    }
    @org.junit.Test
    public void test_for_evaluate_exponential_3() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("-1 ^ 2").value;
        assertEquals(res,1.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("30 - 50+10").value;
        assertEquals(res,-10.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_2() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("-(-1)").value;
        assertEquals(res,1.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_3() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("(((((20)))))").value;
        assertEquals(res,20.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_4() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("((-2))").value;
        assertEquals(res,-2.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_5() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("((-2))").value;
        assertEquals(res,-2.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_6() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("2 ^ (-3)").value;
        assertEquals(res,0.125);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_7() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("8^(-1)").value;
        assertEquals(res,0.125);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_8() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression(".5+.5").value;
        assertEquals(res,1.0);
    }
    @org.junit.Test
    public void test_for_evaluate_multiple_operations_9() throws Exception {
        Expression e = new Expression();
        double res = e.evaluateExpression("0.01+0.03").value;
        assertEquals(res,0.04);
    }
}