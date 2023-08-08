package com.LeetCode.Hot100._031_颜色分类_75;

//20221102
class MySolution {
    public void sortColors(int[] nums) {
        int flag_0 = 0, flag_1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[flag_1];
                nums[flag_1] = temp;
                flag_1++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[flag_0];
                nums[flag_0] = temp;
                if (flag_1 > flag_0) {
                    temp = nums[i];
                    nums[i] = nums[flag_1];
                    nums[flag_1] = temp;
                }
                flag_0++;
                flag_1++;
            }
        }
    }
}
