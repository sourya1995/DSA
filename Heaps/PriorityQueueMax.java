package Heaps;

public class PriorityQueueMax {
  
    private static int[] findKMax(int[] arr, int k){
        int arraySize = arr.length;
        int[] result = new int[k];
        if(k <= arraySize){
            for(int i=0; i < k; i++){
                result[i] = removeMax(arr, arraySize);
                --arraySize;
            }
            return result;
        }
        System.out.println("The value you entered is out of bounds");
        return arr;
    }

    public static int removeMax(int[] heapArray, int heapSize){
        buildMaxHeap(heapArray, heapSize);
        int temp = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        return temp;
    }


    private static void buildMaxHeap(int[]heapArray, int heapSize){
        for(int i = (heapSize - 1)/2; i >=0; i--){
            maxHeapify(heapArray, i, heapSize);
        }
    }
    private static void maxHeapify(int[]heapArray, int index, int heapSize){
        int largest = index;
        while(largest < heapSize/2){
            int left = 2 * index + 1;
            int right = 2 *  index + 2;

            if(left < heapSize && heapArray[left] > heapArray[index]){
                left = largest;
            }

            if(right < heapSize && heapArray[right] > heapArray[largest]){
                right = largest;
            }

            if(largest != index){
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;

            } else{
                break;
            }
        }
    }
    
}
