package com.LeetCode.Hot100._081_打家劫舍III_337;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


//20221120
class MySolution {

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // 先把 dfs(node.left) 单独算出来存成变量，减少计算量
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = left[1] + right[1] + node.val;
        int deselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, deselected};
    }

    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }
}
