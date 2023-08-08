package com.LeetCode.Hot100._035_柱状图中最大的矩形_84;

import java.util.Deque;
import java.util.LinkedList;

//20221105
class MySolution {
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (stack.peek() != -1 && h <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                max = Math.max(max, (i - stack.peek() - 1) * height);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
