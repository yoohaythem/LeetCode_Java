package com.LeetCode.Hot100._094_二叉树的直径_543;


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


//20221122
class MySolution {

    int max = 0;

    public int maxTrace(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxTrace(root.left);
        int right = maxTrace(root.right);
        max = Math.max(max, 1 + left + right);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxTrace(root);
        return max - 1;
    }

}
