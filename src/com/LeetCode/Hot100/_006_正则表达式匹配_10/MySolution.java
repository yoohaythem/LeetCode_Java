package com.LeetCode.Hot100._006_正则表达式匹配_10;

import java.util.Arrays;

//20221026
class MySolution {

    public boolean isMatch(String s, String p) {
        /*
            本题采用动态规划。需要列出他的状态转移方程
            每个字符串前面加一个 " " 字符
            以 行为正则表达式，列为字符串，则有矩阵 s_length * p_length ;
         */
        int s_length = s.length() + 1;
        int p_length = p.length() + 1;
        boolean[][] boolmap = new boolean[s_length][p_length];

//        下面从第一列开始初始化这个数组
        boolmap[0][0] = true;

//        列出第一行的状态转移方程
        for (int i = 1; i < p_length; i++) {
            boolmap[0][i] = p.charAt(i - 1) == '*' && boolmap[0][i - 2];
        }

//        列出其他部分的状态转移方程
        for (int row = 1; row < s_length; row++) {    //行
            char s_ch = s.charAt(row - 1);
            for (int col = 1; col < p_length; col++) {    //列
                char p_ch = p.charAt(col - 1);
                if (p_ch == '*') {
                    boolmap[row][col] = boolmap[row][col - 2] || ((p.charAt(col - 2) == s_ch || p.charAt(col - 2) == '.') && boolmap[row - 1][col]);
                } else if (p_ch == '.' || p_ch == s_ch) {
                    boolmap[row][col] = boolmap[row - 1][col - 1];
                }
            }
        }
        return boolmap[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new boolean[10][10]));
    }
}
