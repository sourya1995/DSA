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

    public static double getMedianOfTwoSortedArraysInLog(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int end_index = size1;
        int start_index = 0;
        int i = 0;
        int j = 0;
        int median = 0;

        while (start_index <= end_index) {
            i = (start_index + end_index) / 2;
            j = ((size1 + size2 + 1) / 2) - i;

            if (i < size1 && j > 0 && array2[j - 1] > array1[i]) {
                start_index = i + 1;
            }

            else if (i > 0 && j < size2 && array2[j] < array1[i - 1]) {
                end_index = i - 1;
            }

            else {
                if (i == 0) {
                    median = array2[i - 1];
                }

                else if (j == 0) {
                    median = array1[i - 1];
                }

                else {
                    median = helper.max_index(array1[i - 1], array2[j - 1]);
                    break;
                }

                if ((size1 + size2) % 2 == 1)
                    return (double) median;

                if (i == size1)
                    return (median + array2[j]) / 2.0;

                if (j == size2)
                    return (median + array1[i]) / 2.0;

                return (median + helper.minimum(array1[i],
                        array2[j])) / 2.0;
            }

        }

    }
}
