package Algorithms.HashTable;

import java.util.LinkedList;
import java.util.List;

public class Bucket {
    public List<Pair> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair>();
    }

    public Integer get(Integer hashkey) {
        for (Pair pair : this.bucket) {
            if (pair.first.equals(hashkey))
                return pair.second;
        }
        return -1;
    }

    public void set(Integer hashkey, Integer value) {

        for (Pair pair : this.bucket) {
            if (pair.first.equals(hashkey)) {
                pair.second = value;
                return;
            }
        }
        this.bucket.add(new Pair(hashkey, value));
    }

    public void delete(Integer hashkey) {
        for (Pair pair : this.bucket) {
            if (pair.first.equals(hashkey)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}
