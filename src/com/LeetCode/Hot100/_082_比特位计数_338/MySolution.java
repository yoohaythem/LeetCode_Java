package com.LeetCode.Hot100._082_比特位计数_338;

//20221120
class MySolution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;   // 这一步可以不写
        int highbit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highbit = i;
            }
            result[i] = result[i - highbit] + 1;
        }
        return result;
    }
}
