package Stacks;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>(arr.length);

        for (int i = arr.length - 1; i >= 0; i--) {
            int currentElement = arr[i];

            while (!stack.isEmpty() && stack.top() <= currentElement) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.top();
            }

            stack.push(currentElement);
        }

        return result;
    }
}
