package Algorithms;

import Algorithms.Sorting.Helper;

public class CountElementOccurrence {
    public static int calcFreq(int[] arr, int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                count++;
        }
        return count;
    }

    public static int calcFreqBinarySearch(int[] arr, int key) {
        int arrSize = arr.length;
        Helper obj = new Helper();
        int index = obj.binarySearch(key, arr, arrSize);

        if (index == -1)
            return 0;

        int count = 1;

        int start = index - 1;
        while (start >= 0 && arr[start] == key) {
            count++;
            start--;
        }

        int end = index + 1;
        while (end < arrSize && arr[end] == key) {
            count++;
            end++;
        }

        return count;
    }

    public static int calcFreqBinarySearchImproved(int[] arr, int key) {
        int arrSize = arr.length;
        int start = 0, end = arrSize - 1, mid, result = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                result = mid;
                end = mid - 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            }
        }

        int start1 = 0, end1 = arrSize - 1, mid1, result1 = -1;

        while (start1 <= end1) {
            mid1 = (start1 + end1) / 2;
            if (arr[mid1] == key) {
                result1 = mid1;
                start1 = mid1 + 1;
            } else if (arr[mid1] > key) {
                end1 = mid1 - 1;
            } else if (arr[mid1] < key) {
                start1 = mid1 + 1;
            }
        }

        if (result == -1 || result1 == -1) {
            return (result1 - result);
        }
        return (result1 - result + 1);
    }
}
