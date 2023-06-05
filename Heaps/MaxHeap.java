package Heaps;

public class MaxHeap {
    private void maxHeapify(int[] heapArray, int index, int heapSize){
        int largest = index; //index here is k
        while(largest < heapSize / 2){
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if(left < heapSize && heapArray[left] > heapArray[index]){
                largest = left;
            }
            if(right < heapSize && heapArray[right] > heapArray[largest]){
                largest = right;
            }

            if(largest != index){
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;

            }
            else
                break;
        }
    }

    public void buildMaxHeap(int[] heapArray, int heapSize){
        for(int i = (heapSize - 1)/2; i>=0; i--){
            maxHeapify(heapArray, i, heapSize);
        }
    }
    
}
