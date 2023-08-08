package com.LeetCode.Hot100._048_只出现一次的数字_136;

//20221107
class MySolution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
