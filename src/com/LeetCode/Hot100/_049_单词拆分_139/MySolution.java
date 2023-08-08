package com.LeetCode.Hot100._049_单词拆分_139;

import java.util.List;

//20221108
class MySolution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {   // i 代表了第几个字符
            for (int j = 0; j < i; j++) {   // j 代表了dp数组中的位置
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
