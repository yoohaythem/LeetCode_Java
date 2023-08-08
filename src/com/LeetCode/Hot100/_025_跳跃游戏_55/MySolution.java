package com.LeetCode.Hot100._025_跳跃游戏_55;

//20221031
class MySolution {
    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        boolean b = mySolution.canJump(new int[]{2, 0, 0});
        System.out.println(b);
    }
}
