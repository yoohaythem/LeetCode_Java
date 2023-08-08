package com.LeetCode.Hot100._073_移动零_283;

//20221116
class MySolution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length, zero_p = 0, num_p = 0;
        while (num_p < n && nums[num_p] != 0) {
            zero_p++;
            num_p++;
        }
        while (num_p < n) {
            while (num_p < n && nums[num_p] == 0) {
                num_p++;
            }
            if (num_p < n) {
                swap(nums, zero_p, num_p);
                zero_p++;
                num_p++;
            }
        }
    }
}
