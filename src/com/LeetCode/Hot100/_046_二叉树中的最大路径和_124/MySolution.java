package com.LeetCode.Hot100._046_二叉树中的最大路径和_124;


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


//20221107
class MySolution {
    public int result = Integer.MIN_VALUE;

    public int node_max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(node_max(node.left), 0);
        int right = Math.max(node_max(node.right), 0);
        result = Math.max(result, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        node_max(root);
        return result;
    }

}
