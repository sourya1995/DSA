package Algorithms.BruteForce;

public class BinarySearch {
    public static int binarySearch(int s, int arr[], int arrSize) {
        if (arrSize <= 0) {
            return -1;
        }

        if (arrSize == 1) {
            if (arr[0] == s) {
                return 0;
            }
            return -1;
        }

        int start = 0;
        int end = arrSize - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < s) {
                start = mid + 1;
            } else if (arr[mid] > s) {
                end = mid - 1;
            } else {
                return mid;

            }

        }
        return -1;
    }

}
