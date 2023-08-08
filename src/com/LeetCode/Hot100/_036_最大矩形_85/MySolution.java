package com.LeetCode.Hot100._036_最大矩形_85;

import java.util.Deque;
import java.util.LinkedList;


//20221105
class MySolution {

    // 84题的函数 CV过来备用
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

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;      // 行
        int n = matrix[0].length;   // 列
        int max = 0;
        int[][] map = new int[m][n];

        for (int i = 0; i < n; i++) {
            map[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = matrix[i][j] == '1' ? map[i - 1][j] + 1 : 0;
            }
        }
        for (int i = 0; i < m; i++) {
            max = Math.max(max, largestRectangleArea(map[i]));
        }
        return max;
    }

}
