package Algorithms.Greedy;

import java.util.Arrays;

public class MinPlatforms {
    public static int findPlatform(int[] arrival, int[] departure){
        int n = arrival.length;
        int result = 0;
        int count = 0;

        for(int index = 0; index < n; index++){
            count = 0;
            for (int i = 1; i < n; i++){
                if(arrival[i] >= arrival[index] && arrival[i] <= departure[index]){
                    count++;
                }
            }
            if(result < count){
                result = count;
            }
    }
    return result;
    
}

public static int findPlatformSort(int[] arrival, int[] departure) {
    int n = arrival.length;
    Arrays.sort(arrival);
    Arrays.sort(departure);

    int platformsNeeded = 1;
    int result = 1;
    int i = 1;
    int j = 0;

    while((i < n) && (j < n)){
        if(arrival[i] < departure[j]){
            platformsNeeded += 1;
            i += 1;
            if(platformsNeeded > result){
                result = platformsNeeded;
            }
        } else {
            platformsNeeded -= 1;
            j += 1;
        }
    }
    return result;
}
}
