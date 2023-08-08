package com.LeetCode.Hot100._015_下一个排列_31;


//20221029
class MySolution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int flag = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                flag = i;
                int change = i;
                for (int j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i - 1]){
                        change = j;
                        break;
                    }
                }
                int swap = nums[change];
                nums[change] = nums[i - 1];
                nums[i - 1] = swap;
                break;
            }
        }
        for (int i = 0; i < n - flag - 1; i++) {
            for (int j = flag; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }
        }
    }
}
