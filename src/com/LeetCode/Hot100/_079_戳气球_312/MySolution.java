package com.LeetCode.Hot100._079_戳气球_312;

//20221119
class MySolution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] val = new int[n];
        val[0] = val[n - 1] = 1;
        System.arraycopy(nums, 0, val, 1, n - 2);
        int[][] dp = new int[n][n];

        // dp[i][j] = val[i]×val[k]×val[j] + dp[i][k] + dp[k][j]
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], val[i] * val[k] * val[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
