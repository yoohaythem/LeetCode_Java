package com.LeetCode.Hot100._098_任务调度器_621;


import java.util.*;

class OfficialSolution {

    // 1. 模拟
    // 选择不在冷却中并且剩余执行次数最多的那个任务
    public int leastInterval_1(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // 任务总数
        int m = freq.size();
        List<Integer> nextValid = new ArrayList<Integer>();   // 下一次可执行时间
        List<Integer> rest = new ArrayList<Integer>();   // 剩余数量
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            // 计算所有任务里，最快的解冻时间
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            // 这里是快速将时间增加到下一个可执行时间，让每次循环都能够执行一个任务
            time = Math.max(time, minNextValid);
            int best = -1;
            // 循环，找不在冷却中并且剩余执行次数最多的那个任务
            for (int j = 0; j < m; ++j) {
                // 上面那个逻辑，使得这个判断至少成立一次，best 总不会为 -1
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {  // 剩余次数不为0, 不在冷却中
                    if (best == -1 || rest.get(j) > rest.get(best)) {  // 剩余执行次数最多
                        best = j;
                    }
                }
            }
            // 将 (nextValid,rest) 更新为 (time+n+1, rest−1)，记录任务下一次冷却结束的时间以及剩余执行次数。
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }

        return time;
    }


    // 2. 构造
    public int leastInterval_2(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

}

