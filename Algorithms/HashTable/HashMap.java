package Algorithms.HashTable;

import java.util.ArrayList;
import java.util.List;

class Pair {
	public Integer first;
	public Integer second;

	public Pair(Integer first, Integer second) {
		this.first = first;
		this.second = second;
	}
}

public class HashMap {
    public int keySpace;
    private List<Bucket> bucketList;

    public HashMap(int keySpace){
        this.keySpace = keySpace;
        this.bucketList = new ArrayList<Bucket>();
        for(int i = 0; i < this.keySpace; i++){
            this.bucketList.add(new Bucket());
        }
    }

    public void put(Integer key, Integer value) {
        if(key == null || value == null)
            return;

        Integer hashKey = key % this.keySpace;
        this.bucketList.get(hashKey).set(key, value);
    }

    public Integer get(Integer key) {
        if(key == null)
            return -1;
        Integer hashKey = key % this.keySpace;
        return this.bucketList.get(hashKey).get(key);
    }

    public void remove(Integer key){
        if(key == null){
            return;
        }
        Integer hashKey = key % this.keySpace;
        this.bucketList.get(hashKey).delete(key);
    }
}
