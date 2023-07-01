package Algorithms.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PythagoreanTriplets {
    static List<int[]> findPythagoreanTriplets(int[] array){
        int n = array.length;
        List<int[]> triples = new ArrayList<int[]>();
        Arrays.sort(array);

        for(int i = 0; i < n; i++){
            if(array[i] == 0) continue;
            int c2 = array[i] * array[i];
            int j = 0;
            int k = n- 1;
            while(j < k) {
                if(j == i || array[j] == 0) {
                    j+=1;
                    continue;
                }

                if(k == i || array[k] == 0) {
                    k -= 1;
                    continue;
                }

                int a2 = array[j] * array[j];
                int b2 = array[k] * array[k];

                if( a2 + b2 == c2){
                    triples.add(new int[]{array[j], array[k], array[i]});
                }

                if(a2 + b2 + (-c2) > 0){
                    k -= 1;
                }

                else{
                    j += 1;
                }
            }
    }
    return triples;
}
