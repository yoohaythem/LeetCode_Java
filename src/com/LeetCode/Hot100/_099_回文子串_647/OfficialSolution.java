package com.LeetCode.Hot100._099_回文子串_647;


class OfficialSolution {

    // 1. 中心拓展
    public int countSubstrings_1(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    // 2. Manacher 算法
    public int countSubstrings_2(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            // 这里是关键算法，是利用了前面子串的对称性，先算出以 i 为中心的回文子串可能的最小半径，后面再以此为基础，做中心拓展
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
}

