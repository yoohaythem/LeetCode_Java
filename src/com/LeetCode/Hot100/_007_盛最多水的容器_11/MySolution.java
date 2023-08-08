package com.LeetCode.Hot100._007_盛最多水的容器_11;

//20221026
class MySolution {
    public int maxArea(int[] height) {
        // 本题采用双指针法求解
        int left = 0, right = height.length - 1, max_area = 0;
        while (left < right) {
            max_area = Math.max(max_area, (right - left) * Math.min(height[left], height[right]));
            int nothing = height[left] < height[right] ? left++ : right--;
        }
        return max_area;
    }
}
