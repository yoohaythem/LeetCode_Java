package com.LeetCode.Hot100._048_只出现一次的数字_136;


class OfficialSolution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

