package com.LeetCode.Hot100._001_两数之和_1;

import java.util.Arrays;
import java.util.HashMap;


//20221023
class MySolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])){
                hash.put(target - nums[i], i);
            }else {
                return new int[]{hash.get(nums[i]), i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MySolution cls = new MySolution();
        System.out.println(Arrays.toString(cls.twoSum(new int[]{3, 2, 4}, 6)));
    }

}

