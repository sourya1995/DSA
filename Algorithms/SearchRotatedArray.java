package Algorithms;

public class SearchRotatedArray {
    static int searchRotatedArrayBF(int arr[], int left, int right, int n) {
        if (right <= 0) {
            return -1;
        }

        for (int i = 0; i < right; i++) {
            if (arr[i] == n) {
                return i;
            }

        }
        return -1;
    }

    static int searchRotatedArrayBSearch(int arr[], int left, int right, int n){
        int mid = (left + right)/2;
        if(n == arr[mid]){
            return mid;
        }

        if(right <  left){
            return -1;
        }

        if(arr[left] < arr[mid]){
            if(n >= arr[left] && n <= arr[mid]){
                return searchRotatedArrayBF(arr, left, mid - 1, n);

        } else{
            return searchRotatedArrayBF(arr, mid + 1, right, n);
        }
    }else if(arr[mid] < arr[right]){
        if(n > arr[mid] && n <= arr[right]){
            return searchRotatedArrayBF(arr, mid + 1, right, n);
        } else{
            return searchRotatedArrayBF(arr, left, mid - 1, n);
        }
    } else if(arr[left] == arr[mid]){
        if(arr[mid] != arr[right]){
            return searchRotatedArrayBF(arr, mid + 1, right, n);
        } else{
            int result = searchRotatedArrayBF(arr, left, mid - 1, n);
            if(result == -1){
                return searchRotatedArrayBF(arr, mid + 1, right, n);
            }else {
                return result;
            }
        }

    }
    return -1;
    
}
