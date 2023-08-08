package com.LeetCode.Hot100._080_零钱兑换_322;


import java.util.Arrays;

class OfficialSolution {

    // 1. 记忆化搜索
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);  // 这里，new int[amount]就是那个记忆数组
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);  // 函数内更改记忆数组，并重新传入
            if (res >= 0 && res < min) {   // 这里 res < min 替代了 Math.min(min, 1+res)，优化了计算量
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    // 2. 动态规划
    public int coinChange_2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // 这里用了个很巧妙的办法，让所有无法组成的情况，dp[i]全部大于 max
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}

