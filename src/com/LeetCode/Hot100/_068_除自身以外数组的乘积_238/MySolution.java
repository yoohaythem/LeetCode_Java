package com.LeetCode.Hot100._068_除自身以外数组的乘积_238;

//20221115
class MySolution {

    // 1. 使用辅助数组
    public int[] productExceptSelf_1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n], left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    // 2. 不使用辅助数组
    public int[] productExceptSelf_2(int[] nums) {
        int n = nums.length, right = 1;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right *= nums[i];
        }
        return result;
    }

}
