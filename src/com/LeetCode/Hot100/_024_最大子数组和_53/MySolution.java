package com.LeetCode.Hot100._024_最大子数组和_53;

//20221031
class MySolution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], now = nums[0];
        for (int i = 1; i < nums.length; i++) {
            now = Math.max(now, 0) + nums[i];
            max = Math.max(max, now);
        }
        return max;
    }
}
