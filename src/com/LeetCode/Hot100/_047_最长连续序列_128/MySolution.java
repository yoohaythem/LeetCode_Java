package com.LeetCode.Hot100._047_最长连续序列_128;

import java.util.HashSet;

//20221107
class MySolution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            int temp = 1, first = num;
            if (!set.contains(first - 1)) {
                while (set.contains(first + 1)) {
                    first++;
                    temp++;
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
