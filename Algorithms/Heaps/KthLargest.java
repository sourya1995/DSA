package Algorithms.Heaps;

import java.util.PriorityQueue;

public class KthLargest {
    public int k;
    public PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums){
        this.k = k;
        heap = new PriorityQueue<Integer>();
        for (int num : nums){
            heap.offer(num);
        }

        while (heap.size() > k){
            heap.poll();
        }
    }

    public void add(int val){
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        } 
    }

    public int returnKthLargest(){
        return this.heap.peek();
    }
}
