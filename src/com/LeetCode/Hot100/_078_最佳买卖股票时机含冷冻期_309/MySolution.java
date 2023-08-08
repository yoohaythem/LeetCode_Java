package com.LeetCode.Hot100._078_最佳买卖股票时机含冷冻期_309;

//20221119
class MySolution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 0 -- 持有一只股票 (买入当天算持有，卖出当天不算持有)；
        // 1 -- 不持有股票且是卖出当天； 2 -- 不持有股票且不是卖出当天
        /*
            dp[i][0] = dp[i-1][0] 或者 dp[i-1][2] - prices[i]
            dp[i][1] = dp[i-1][0] + prices[i]
            dp[i][2] = dp[i-1][1] 或者 dp[i-1][2]
         */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
