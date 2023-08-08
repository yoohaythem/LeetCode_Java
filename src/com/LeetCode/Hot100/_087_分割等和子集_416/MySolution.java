package com.LeetCode.Hot100._087_分割等和子集_416;

//20221121
class MySolution {
    public boolean canPartition(int[] nums) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if ((sum & 1) == 1 || max > sum >> 1) {
            return false;
        }
        int n = nums.length, target = sum >> 1;
        boolean[][] dp = new boolean[n][target + 1];  // 前n个数，和为target
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                // 如果前 i 个数和为 j，那么前 i-1 个数和为 j，或者前 i-1 个数和为 j-nums[i] (j >= nums[i])
                dp[i][j] = dp[i - 1][j] || (j >= nums[i] && dp[i - 1][j - nums[i]]);
            }
        }
        return dp[n - 1][target];
    }
}
