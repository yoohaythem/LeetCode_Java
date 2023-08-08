package com.LeetCode.Hot100._069_滑动窗口最大值_239;

import java.util.*;

//20221115
class MySolution {
    // 1. 使用 priorityQueue 优先队列
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((n1, n2) -> n2[0] != n1[0] ? n2[0] - n1[0] : n2[1] - n1[1]);
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new int[]{nums[i], i});
            if (i >= k - 1) {
                int[] max = priorityQueue.peek();
                while (max[1] <= i - k) {
                    priorityQueue.poll();
                    max = priorityQueue.peek();
                }
                result[i - k + 1] = max[0];
            }
        }
        return result;
    }

    // 2. 使用队列，但是超时
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length, count;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            count = 0;
            while (deque.size() > 0 && nums[i] >= deque.peekLast()) {
                deque.removeLast();
                count++;
            }
            for (int j = 0; j <= count; j++) {
                deque.addLast(nums[i]);
            }
            if (deque.size() > k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = deque.peekFirst();
            }
        }
        return result;
    }

    // 3. 使用队列，不超时的方法，因为存储了下标而不是值
    public int[] maxSlidingWindow_3(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length, count;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

}
