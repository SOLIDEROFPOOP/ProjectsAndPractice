public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] profit){
        int minPrice = profit[0];
        int maxProfit = 0;
        for (int i = 0; i < profit.length; i++){
            minPrice = Math.min(minPrice , profit[i]);
            int potentialProfit = profit[i] - minPrice;
            maxProfit = Math.max(potentialProfit , maxProfit);
        }
        return maxProfit;
    }
}
