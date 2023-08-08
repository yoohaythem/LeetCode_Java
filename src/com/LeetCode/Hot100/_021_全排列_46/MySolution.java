package com.LeetCode.Hot100._021_全排列_46;

import java.util.ArrayList;
import java.util.List;

//20221031
class MySolution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        traceback(result, new ArrayList<>(), nums);
        return result;
    }

    public void traceback(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (!temp.contains(num)) {
                temp.add(num);
                traceback(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
