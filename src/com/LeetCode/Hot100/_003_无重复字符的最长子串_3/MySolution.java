package com.LeetCode.Hot100._003_无重复字符的最长子串_3;

import java.util.HashSet;

//20221024
class MySolution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> letters = new HashSet<>();
        while (right < n) {
            while (letters.contains(s.charAt(right))) {
                letters.remove(s.charAt(left));
                left++;
            }
            letters.add(s.charAt(right));
            right++;
            max = Math.max((right - left), max);
        }
        return max;
    }
}
