package com.LeetCode.Hot100._092_目标和_494;

import java.util.Arrays;

//20221122
class MySolution {

    // 1. dfs
    int count = 0;

    public void dfs(int[] nums, int target, int position) {
        if (position == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }
        dfs(nums, target + nums[position], position + 1);
        dfs(nums, target - nums[position], position + 1);
    }

    public int findTargetSumWays_1(int[] nums, int target) {
        dfs(nums, target, 0);
        return count;
    }


    // 2. 动态规划
    public int findTargetSumWays_2(int[] nums, int target) {
        int n = nums.length, sum = Arrays.stream(nums).sum(), negative = (sum - target) / 2;
        if (sum < target || (sum - target) % 2 == 1) {
            return 0;
        }
        // 所有负数数字和 = (sum-target)/2
        int[][] dp = new int[n + 1][negative + 1];   // 前 n 个数，和为 negative
        dp[0][0] = 1;
        // 前 i 个数字，和为 j
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= negative; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
        return dp[n][negative];
    }

}
