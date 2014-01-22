package library;

public class Evaluator {
    public int evaluate(String expression) {
        if (!expression.contains(" ")) return 0;
        String contents[] = expression.split(" ");
        int result = 0;
        try {
            int num1 = Integer.parseInt(contents[0]);
            int num2 = Integer.parseInt(contents[2]);
            if (contents[1].equals("+")) result = add(num1, num2);
            if (contents[1].equals("-")) result = subtract(num1, num2);
            if (contents[1].equals("*")) result = multiply(num1, num2);
            if (contents[1].equals("/")) result = divide(num1, num2);
            if (contents[1].equals("^")) result = calculatePower(num1, num2);

        } catch (Exception e) {
            System.err.println("something is wrong");
        }
        return result;
    }


    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }
    private int multiply(int num1, int num2) {
        return num1 * num2;
    }
    private int divide(int num1, int num2) {
        return num1 / num2;
    }
    private int calculatePower(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }
}

