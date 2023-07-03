package Algorithms.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public static ArrayDeque<Integer> getMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>(); //max element in each sliding window
        Deque<Integer> list = new ArrayDeque<Integer>(); //indices of potential maximum elements

        if (arr.length > 0) {
            if (arr.length < windowSize)
                windowSize = arr.length;
            for (int i = 0; i < windowSize; i++) {
                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                    list.removeLast();
                }

                list.addLast(i);
            }

            for (int i = windowSize; i < arr.length; i++) {
                result.add(arr[list.peek()]);

                while (!list.isEmpty() && list.peek() <= i - windowSize)
                    list.removeFirst();

                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()])
                    list.removeFirst();

                list.addLast(i);

            }

            result.add(arr[list.peek()]);
            return result;
        } else
            return result;
    }
}
