package com.LeetCode.Hot100._100_每日温度_739;

import java.util.Deque;
import java.util.LinkedList;

//20221123
class MySolution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 维护一个单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int p = stack.pop();
                answer[p] = i - p;
            }
            stack.push(i);
        }
        return answer;
    }
}
