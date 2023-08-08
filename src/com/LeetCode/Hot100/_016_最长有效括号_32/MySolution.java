package com.LeetCode.Hot100._016_最长有效括号_32;

//20221030
class MySolution {
    public int longestValidParentheses(String s) {
        int n = s.length(), max = 0, left = 0, right = 0, couples = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
                couples++;
            } else if (left > 0) {
                left--;
                couples++;
                if (left == 0){
                    max = Math.max(max, couples);
                }
            } else {
                max = Math.max(max, couples);
                couples = 0;
            }
        }
        if (left == 0){
            max = Math.max(max, couples);
        }
        couples = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
                couples++;
            } else if (right > 0) {
                right--;
                couples++;
                if (right == 0){
                    max = Math.max(max, couples);
                }
            } else {
                max = Math.max(max, couples);
                couples = 0;
            }
        }
        if (right == 0){
            max = Math.max(max, couples);
        }
        return max;
    }
}
