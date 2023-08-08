package com.LeetCode.Hot100._057_多数元素_169;

//20221109
class MySolution {
    public int majorityElement(int[] nums) {
        int vote = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                vote++;
            } else {
                if (vote == 0) {        // vote == 0 这段逻辑可以放在第一个 if 外面。
                    result = nums[i];
                    vote++;
                } else {
                    vote--;
                }
            }
        }
        return result;
    }

}
