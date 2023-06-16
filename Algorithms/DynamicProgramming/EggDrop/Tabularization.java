package Algorithms.DynamicProgramming.EggDrop;

public class Tabularization {
    public static int eggDrop(int eggs, int floors){
        if(eggs <= 0) return 0;
        if(floors == 1 || floors == 0) return floors;
        if(eggs == 1) return floors;

        int[][] eggFloor = new int[eggs + 1][floors + 1];
        int res;
        int i, j, x;

        for(i = 1; i <= eggs; i++){
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;

        }

        for(j = 1; j <= floors; j++)
            eggFloor[1][j] = j;

        for(i = 2; i <= eggs; i++){
            for(j=2; j <= floors; j++){
                eggFloor[i][j] = Integer.MAX_VALUE;
                for(x = 1; x <= j; x++){
                    res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    if(res < eggFloor[i][j])
                        eggFloor[i][j] = res;
            }
        }

        

    }
    return eggFloor[eggs][floors];
}
