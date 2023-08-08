package com.LeetCode.Hot100._033_子集_78;

import java.util.ArrayList;
import java.util.List;

//20221102
class MySolution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int sum = 1 << n;
        List<List<Integer>> maps = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1){
                    temp.add(nums[j]);
                }
            }
            maps.add(new ArrayList<>(temp));
        }
        return maps;
    }
}
