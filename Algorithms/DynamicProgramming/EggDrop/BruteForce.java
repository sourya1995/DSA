package Algorithms.DynamicProgramming.EggDrop;

public class BruteForce {
    public static int eggDrop(int eggs, int floors){
        if(eggs <= 0) return 0;
        if(floors == 1 || floors == 0) return floors;
        if(eggs == 1) return floors;
        int min = Integer.MAX_VALUE;
        int x, res;
        for(x = 1; x <= floors; x++){
            res = Math.max(eggDrop(eggs - 1, x - 1), eggDrop(eggs, floors - x));
            if(res < min) min = res;
           
        }
         return min + 1;
    }
}
