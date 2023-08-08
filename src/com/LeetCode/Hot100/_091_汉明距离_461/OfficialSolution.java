package com.LeetCode.Hot100._091_汉明距离_461;


class OfficialSolution {

    // 1. 内置位计数功能
    public int hammingDistance_1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // 2. 移位实现位计数
    public int hammingDistance_2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }

    // 3. Brian Kernighan 算法
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

}

