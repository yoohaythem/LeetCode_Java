package com.LeetCode.Hot100._020_接雨水_42;

import java.util.Deque;
import java.util.LinkedList;

//20221030
class MySolution {
    // 1. 双指针,  0 ms	42.5 MB
    // 奇怪了，明明只有这个空间复杂度：O(1)。
    public int trap_1(int[] height) {
        int result = 0, left = -1, right = height.length, leftMax = 0, rightMax = 0;
        while (left < height.length - 1 && left < right) {
            if (leftMax <= rightMax) {
                left++;
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += (leftMax - height[left]);
                }
            } else {
                right--;
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[right]);
                }
            }
        }
        return result;
    }

    // 2. 单调栈（单调递减）,	2 ms	41.3 MB
    public int trap_2(int[] height) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[top]);
            }
            stack.push(i);
        }
        return result;
    }

    // 3. 动态规划, 1 ms	42 MB
    public int trap_3(int[] height) {
        int n = height.length, max = 0, result = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        for (int i = 0; i < n; i++) {
            result += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        int trap = mySolution.trap_1(new int[]{0, 2, 1, 3});
        System.out.println(trap);
    }
}
