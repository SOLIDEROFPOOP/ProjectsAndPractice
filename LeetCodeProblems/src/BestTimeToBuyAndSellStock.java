public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] profit){
        int maxProfit = 0;
        int buy = profit[0];
        int sell;
        for (int i = 0; i < profit.length; i++){
            if (buy > profit[i]) buy = profit[i];
            else if (buy < profit[i]) maxProfit = Math.max(profit[i] - buy, maxProfit);
        }
        return maxProfit;
    }
}
