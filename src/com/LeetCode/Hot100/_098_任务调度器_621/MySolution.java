package com.LeetCode.Hot100._098_任务调度器_621;

import java.security.KeyStore;
import java.util.*;

//20221123
class MySolution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxExec = 0, maxCount = 0;
        for (char ch : tasks) {
            int time = map.getOrDefault(ch, 0) + 1;
            map.put(ch, time);
            maxExec = Math.max(maxExec, time);
        }
        for (Map.Entry<Character, Integer> character : map.entrySet()) {
            if (character.getValue() == maxExec) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (maxExec - 1) * (n + 1) + maxCount);
    }
}
