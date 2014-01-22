package library;

import static org.junit.Assert.assertEquals;

public class EvaluatorTest extends Evaluator {
    @org.junit.Test
    public void testEvaluate() throws Exception {
        String str = "2 + 3";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,5);
    }
    @org.junit.Test
    public void test_for_adding_two_numbers() throws Exception {
        String str = "45 + 10";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,55);
    }
    @org.junit.Test
    public void test_for_adding_two_numbers_if_space_is_not_given() throws Exception {
        String str = "45+10";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,0);
    }
    @org.junit.Test
    public void test_if_only_one_operand_is_given() throws Exception {
        String str = "2";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,0);
    }
    @org.junit.Test
    public void test_for_subtraction_of_two_numbers() throws Exception {
        String str = "40 - 10";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,30);
    }
    @org.junit.Test
    public void test_for_multiplication_of_two_numbers() throws Exception {
        String str = "4 * 10";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,40);
    }
    @org.junit.Test
    public void test_for_division_of_two_numbers() throws Exception {
        String str = "22 / 3";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,7);
    }
    @org.junit.Test
    public void test_for_calculating_power_of_two_numbers() throws Exception {
        String str = "2 ^ 3";
        Evaluator e = new Evaluator();
        int res = e.evaluate(str);
        assertEquals(res,8);
    }

}

