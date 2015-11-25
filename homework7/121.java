public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) {
            return 0;
        }
        
        Integer[] mins = new Integer[prices.length]; // first n days
        Integer[] maxs = new Integer[prices.length]; // last n days
        mins[0] = prices[0];
        maxs[prices.length-1] = prices[prices.length-1];
        
        // fill max prices, from right to left
        for (int i=prices.length-2; i>=0; i--) {
            if (prices[i]>maxs[i+1])
                maxs[i] = prices[i];
            else
                maxs[i] = maxs[i+1];
        }
        
        // fill min prices, and calculate the biggest profit, from left to right
        int biggestProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i]<mins[i-1])
                mins[i] = prices[i];
            else
                mins[i] = mins[i-1];
            
            int profit = maxs[i] - mins[i];
            if (profit>biggestProfit)
                biggestProfit = profit;
        }
        
        return biggestProfit;
    }
}


//求最大差价。买必须发生在卖之前，因此这一段时间内，找一个切分点，使得后半段的最大值减去前半段的最小值这个差最大。因此在填最大值表的时候，要从右往左；而填最小值表的时候，要从左往右：

