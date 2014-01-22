package library;

public class Evaluator {
    public int evaluate(String expression) {
        if (!expression.contains(" ")) return 0;
        String contents[] = expression.split(" ");
        int num1 = Integer.parseInt(contents[0]);
        int num2 = Integer.parseInt(contents[2]);
        int result = 0;
        if (contents[1].equals("+"))
            result = add(num1,num2);
        return result;
    }
    private int add(int num1, int num2) {
        return num1 + num2;
    }
}
