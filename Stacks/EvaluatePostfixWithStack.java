package Stacks;

public class EvaluatePostfixWithStack {

    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (!Character.isDigit(c)) {
                Integer x = stack.pop();
                Integer y = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }

            } else
                stack.push(Character.getNumericValue(c)); //
        }
        return stack.pop();

    }
}
