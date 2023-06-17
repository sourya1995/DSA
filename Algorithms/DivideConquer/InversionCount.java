package Algorithms.DivideConquer;

public class InversionCount {
    public static int InvCount(int[] arr) {
        int size = arr.length;
        int count = 0;
        for (int curr = 0; curr < size - 1; curr++) {
            for (int right = curr + 1; right < size; right++) {
                if (arr[curr] > arr[right]) {
                    count++;
                }
                
            }
        }
        return count;
    }

    public static int countInversionUtil(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if(right > left){
            mid = (left + right)/2;
            invCount = countInversionUtil(arr, temp, left, mid);
            invCount += countInversionUtil(arr, temp, mid+1, right);
            invCount += merge(arr, temp, left, mid+1, right);
        }
        return invCount;
    }

    public static int merge(int arr[], int temp[], int left, int mid, int right){
        int invCount = 0;
        int i = left;
        int j = mid;
        int k = left;

        while((i <= mid - 1) && (j <= right)){
            if(arr[i] <= arr[j])
            temp[k++] = arr[i++];

            else {
                temp[k++] = arr[j++];
                invCount = invCount + (mid - i);
            }
        }
        return invCount;
    }

    public static int countInversions(int[] arr){
        int size = arr.length;
        int[] temp = new int[size];
        return countInversionUtil(arr, temp, 0, size - 1);
    }


}
