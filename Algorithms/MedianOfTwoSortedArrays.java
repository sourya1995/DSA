package Algorithms;

import Algorithms.Sorting.Helper;

public class MedianOfTwoSortedArrays {
    static Helper helper = new Helper();
    public static double getMedianOfTwoSortedArrays(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int arraySize = size1 + size2;
        int halfArraySize = arraySize / 2;
        int i = 0;
        int j = 0;
        int count;
        int median = -1;
        int prevMedian = -1;

        for (count = 0; count < halfArraySize; count++) {
            prevMedian = median;
            if (i != size1 && j != size2) {
                if (array1[i] > array2[j]) {
                    median = array2[j];
                    j++;
                } else {
                    median = array1[i];
                    i++;
                }
            }

            else if (i < size1) {
                median = array1[i];
                i++;
            } else {
                median = array2[j];
                j++;
            }
        }
        if (arraySize % 2 == 1) {
            return median;
        } else {
            return (median + prevMedian) / 2.0;
        }

    }
}
