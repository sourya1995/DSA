package Algorithms.DynamicProgramming.EggDrop;

public class Memoization {
    public static int eggDropRec(int eggs, int floors, int[][] lookupTable){
        if(eggs <= 0) return 0;
        if(floors == 1 || floors == 0) return floors;
        if(eggs == 1) return floors;
        lookupTable[eggs][floors] = Integer.MAX_VALUE;
        int x, res;
        for(x = 1; x <= floors; x++){
            res = 1 + Math.max(eggDropRec(eggs - 1, x - 1, lookupTable), eggDropRec(eggs, floors - x, lookupTable));
            if(res < lookupTable[eggs][floors]) 
                lookupTable[eggs][floors] = res;
        }
        return lookupTable[eggs][floors];
    }

    public static int eggDrop(int eggs, int floors){
        int[][] lookupTable;
        lookupTable = new int[eggs + 1][];
        for(int i =0; i < eggs + 1; i++)
            lookupTable[i] = new int[floors + 1];
            for(int j =0; j < floors + 1; j++)
                lookupTable[i][j] = 0;
    return eggDropRec(eggs, floors, lookupTable);
    }
    
}

