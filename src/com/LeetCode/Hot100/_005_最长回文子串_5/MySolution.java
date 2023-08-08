package com.LeetCode.Hot100._005_最长回文子串_5;


//20221024
class MySolution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = s.substring(0, 1);
        int max_length = 1;
        for (int i = 1; i < n - max_length / 2; i++) {
            int j = 1;
            while (i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j)) {
                if (max_length < 2 * j + 1) {
                    max_length = 2 * j + 1;
                    max = s.substring(i - j, i + j + 1);
                }
                j++;
            }
            j = 0;
            if (s.charAt(i) == s.charAt(i - 1)) {
                while (i - j - 1 >= 0 && i + j < n && s.charAt(i - 1 - j) == s.charAt(i + j)) {
                    if (max_length < 2 * j + 2) {
                        max_length = 2 * j + 2;
                        max = s.substring(i - j - 1, i + j + 1);
                    }
                    j++;
                }
            }
        }
        return max;
    }
}
