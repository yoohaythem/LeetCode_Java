package com.LeetCode.Hot100._045_买卖股票的最佳时机_121;

//20221107
class MySolution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy_min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            buy_min = Math.min(buy_min, prices[i - 1]);
            max = Math.max(max, prices[i] - buy_min);
        }
        return max;
    }

}
