package com.LeetCode.Hot100._091_汉明距离_461;

//20221121
class MySolution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y, result = 0;
        while (temp > 0) {
            result++;
            temp &= (temp - 1);
        }
        return result;
    }
}
