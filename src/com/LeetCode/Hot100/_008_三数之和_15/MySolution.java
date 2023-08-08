package com.LeetCode.Hot100._008_三数之和_15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//20221027
class MySolution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] <= 0) {             // 这里用for循环，整段逻辑会更清楚、更好
                int left = i + 1, right = n - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else if (nums[i] + nums[left] + nums[right] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else {
                        right--;
                    }
                }
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MySolution cls = new MySolution();
        System.out.println(cls.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    }
}
