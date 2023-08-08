package com.LeetCode.Hot100._018_在排序数组中查找元素的第一个和最后一个位置_34;

//20221030
class MySolution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1, start, end;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return new int[]{-1, -1};
        } else {
            start = left;
        }

        left = 0;
        right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        end = right;
        return new int[]{start, end};
    }
}
