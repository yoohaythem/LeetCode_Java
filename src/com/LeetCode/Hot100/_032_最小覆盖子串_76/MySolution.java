package com.LeetCode.Hot100._032_最小覆盖子串_76;

import java.util.HashMap;
import java.util.Map;

//20221102
class MySolution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = -1, count = t.length(), max = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) >= 0) {
                    count--;
                }
            }
            if (count == 0) {
                while (count == 0) {
                    left++;
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left--;
                    count--;
                }
                if (i - left < max) {
                    max = i - left;
                    result = s.substring(left + 1, i + 1);
                }
                while (left < i && count < 2) {
                    left++;
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left--;
                    count--;
                }
            }
        }
        return result;
    }
}
