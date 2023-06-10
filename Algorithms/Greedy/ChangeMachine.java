package Algorithms.Greedy;

import java.util.ArrayList;

public class ChangeMachine {
    public static int[] coins = {25, 10, 5, 1};

    public static ArrayList<Integer> getMinCoins(int amount){
        ArrayList<Integer> change = new ArrayList<Integer>();

        for(int i = 0; i < coins.length && amount > 0; i++){
            while(amount >= coins[i]){
                amount -= coins[i];
                change.add(coins[i]);
            }
        }
        return change;
    }
}
