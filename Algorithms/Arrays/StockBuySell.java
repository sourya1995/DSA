package Algorithms.Arrays;

 class Tuple <X, Y>{
        public X x;
        public Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

public class StockBuySell {
   public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stockNums){
        if(stockNums == null || stockNums.length < 2){
            return null;
        }

        int currentBuy = stockNums[0];
        int globalSell = stockNums[1];

        int globalProfit = globalSell - currentBuy;
        int currentProfit = Integer.MIN_VALUE;

        for(int i = 1; i < stockNums.length; i++){
            currentProfit = stockNums[i] - currentBuy;

            if(currentProfit > globalProfit){
                globalProfit = currentProfit;
                globalSell = stockNums[i];

            }

            if(currentBuy > stockNums[i]){
                currentBuy = stockNums[i];
            }

           

        }
        Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(globalSell - globalProfit, globalSell);
        return result;
   }
}
