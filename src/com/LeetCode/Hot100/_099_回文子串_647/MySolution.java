package com.LeetCode.Hot100._099_回文子串_647;

//20221123
class MySolution {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Math.min(i + 1, n - i); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = 0; j < Math.min(i + 1, n - i - 1); j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}