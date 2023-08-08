package com.LeetCode.Hot100._058_打家劫舍_198;

//20221109
class MySolution {
    public int rob(int[] nums) {
        int n = nums.length + 1;
        int[] dp = new int[n];
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
