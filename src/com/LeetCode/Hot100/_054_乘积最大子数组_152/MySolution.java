package com.LeetCode.Hot100._054_乘积最大子数组_152;

//20221109
class MySolution {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int multi = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (multi == 0) {
                multi = 1;
            }
            multi *= nums[i];
            if (multi > 0) {
                max = Math.max(max, multi);
            }
        }
        multi = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (multi == 0) {
                multi = 1;
            }
            multi *= nums[i];
            if (multi > 0) {
                max = Math.max(max, multi);
            }
        }
        return max;
    }
}
