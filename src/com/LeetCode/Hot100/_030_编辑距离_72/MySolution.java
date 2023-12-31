package com.LeetCode.Hot100._030_编辑距离_72;

//20221102
class MySolution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                int left_top = dp[i - 1][j - 1] + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    left_top--;
                }
                dp[i][j] = Math.min(left, Math.min(top, left_top));
            }
        }
        return dp[m][n];
    }
}
