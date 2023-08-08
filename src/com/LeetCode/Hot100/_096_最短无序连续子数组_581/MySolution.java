package com.LeetCode.Hot100._096_最短无序连续子数组_581;



//20221122
class MySolution {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, left = 0, right = -1, max = nums[0], min = nums[n - 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            if (nums[n - 1 - i] > min) {
                left = n - 1 - i;
            } else {
                min = nums[n - 1 - i];
            }
        }
        return right - left + 1;
    }

}
