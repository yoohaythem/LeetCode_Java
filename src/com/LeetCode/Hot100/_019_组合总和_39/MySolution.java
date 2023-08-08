package com.LeetCode.Hot100._019_组合总和_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//20221030
class MySolution {

    // 1. 不排序直接回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        traceback(candidates, result, new ArrayList<>(), candidates.length, target, 0);
        return result;
    }

    public void traceback(int[] candidates, List<List<Integer>> result, List<Integer> nums, int n, int left, int start) {
        if (left < 0){
            return;
        }
        if (left == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i < n; i++) {
            nums.add(candidates[i]);
            left = left - candidates[i];
            traceback(candidates, result, nums, n, left, i);
            left = left + nums.remove(nums.size() - 1);
        }
    }

    // 2. 排序后回溯，这种似乎要快一些
    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        traceback_2(candidates, result, new ArrayList<>(), candidates.length, target, 0);
        return result;
    }

    public void traceback_2(int[] candidates, List<List<Integer>> result, List<Integer> nums, int n, int left, int start) {
        for (int i = start; i < n; i++) {
            if (left >= candidates[i]) {
                nums.add(candidates[i]);
                left = left - candidates[i];
                traceback_2(candidates, result, nums, n, left, i);
                left = left + nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }
        if (left == 0) {
            result.add(new ArrayList<>(nums));
        }
    }


    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        List<List<Integer>> lists = mySolution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
