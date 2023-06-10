package Algorithms.Greedy;

public class MinHeap {
    int[] heapArray;
    int index;
    int heapSize;

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    private static void minHeapify(int[] heapArray, int index, int heapSize) {
        int smallest = index;

        while (smallest < heapSize / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < heapSize && heapArray[left] < heapArray[index]) {
                smallest = left;
            }

            if (right < heapSize && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[smallest];
                heapArray[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    public static void buildMinHeap(int[] heapArray, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(heapArray, i, heapSize);
        }
    }

    private static int[] findKMin(int[] arr, int k) {
        int arraySize = arr.length;
        int[] result = new int[k];
        if (k <= arraySize) {
            for (int i = 0; i < k; i++) {
                result[i] = removeMin(arr, arraySize);
                --arraySize;
            }
            return result;
        }
        System.out.println("The value you entered is out of bounds");
        return arr;
    }

    public static int removeMin(int[] heapArray, int heapSize) {
        buildMinHeap(heapArray, heapSize);
        int temp = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        return temp;
    }

    public boolean SizeIsOne() {
        return true;
    }

void insertKey(int x){
    heapSize++;
    int i = heapSize - 1;
    heapArray[i] = x;

    while(i!= 0 && heapArray[parent(i)] > heapArray[i]){
        swap(i, parent(i));
        i = parent(i);
    }
}


  void swap(int x, int y) {
   int temp = heapArray[x];
   heapArray[x] = heapArray[y];
   heapArray[y] = temp;
  }

}
