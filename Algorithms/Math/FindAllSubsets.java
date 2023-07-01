package Algorithms.Math;

import java.util.HashSet;
import java.util.List;

public class FindAllSubsets {
    static int getBit(int num, int bit){
        int temp = (1 << bit);
        temp = temp & num;
        if(temp == 0){
            return 0;
        }
        return 1;
    }

    static void findAllSubsets(List<Integer> v, List<HashSet<Integer>> sets){
        if(!v.isEmpty()){
            int subsetsCount = (int) (Math.pow((double) 2, (double) v.size()));
            for(int i = 0; i < subsetsCount; i++){
                HashSet<Integer> set = new HashSet<Integer>();
                for(int j = 0; j < v.size(); j++){
                    if(getBit(i, j) == 1){
                        int x = v.get(j);
                        set.add(x);
                    }
                }
                sets.add(set);
            }
        } else {
            HashSet<Integer> emptySet = new HashSet<Integer>();
            sets.add(emptySet);
        }
    }
}
