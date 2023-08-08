package com.LeetCode.Hot100._076_最长递增子序列_300;

//20221117
class MySolution {

    public int lengthOfLIS_1(int[] nums) {
        int n = nums.length, max, result = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result = Math.max(result, max);
        }
        return result;
    }

    public int lengthOfLIS_2(int[] nums) {
        int n = nums.length, result = 1;
        int[] tail = new int[n];
        tail[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > tail[result - 1]) {
                // 一下两行代码可以简化为  ail[++result] = nums[i];
                tail[result] = nums[i];
                result++;
            } else {
                // 下面的 for 循环，可以用二分查找来缩短时间.
                // 目标：在有序数组中，查找刚好大于目标值的值，  tail[j-1] <= nums[i] <= tail[j]
                /*
                    int left = 0, right = result - 1, mid;
                    while (left < right) {
                        mid = (left + right) / 2;
                        if (tail[mid] == nums[i]) {
                            left = mid;
                            break;
                        } else if (tail[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    tail[left] = nums[i];
                 */
                // 当然，以上只是一种解法，参考 OfficialSolution 里面的二分法，解法更好

                for (int j = 0; j < result; j++) {
                    if (nums[i] <= tail[j]) {
                        tail[j] = nums[i];
                        break;
                    }
                }

            }
        }
        return result;
    }

}
