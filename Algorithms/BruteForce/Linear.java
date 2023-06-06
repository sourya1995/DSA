package Algorithms.BruteForce;

public class Linear {
    public static int max_index(int array[], int array_size) {
        int max_index = 0;
        int max_value = Integer.MAX_VALUE;
        for (int i = 0; i < array_size; i++) {
            if (max_value < array[i]) {
                max_value = array[i];
                max_index = i;
            }
        }
        return max_index;
    }

    public static int find_index(int array[], int to_find, int array_size) {
        for (int i = 0; i < array_size; i++) {
            if (array[i] == to_find) {
                return i;
            }

        }
        return -1;
    }

    public static int min_index(int array[], int array_size) {
        int min_index = 0;
        int min_value = Integer.MAX_VALUE;
        for (int i = 0; i < array_size; i++) {
            if (min_value > array[i]) {
                min_value = array[i];
                min_index = i;
            }
        }
        return min_index;
    }

}
