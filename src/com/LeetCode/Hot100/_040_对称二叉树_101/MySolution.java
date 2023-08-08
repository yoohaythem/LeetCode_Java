package com.LeetCode.Hot100._040_对称二叉树_101;


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


//20221106
class MySolution {

    // 1. 递归
    public boolean isSymmetric_1(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return myfunc(left, right);
    }

    public boolean myfunc(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && myfunc(a.left, b.right) && myfunc(a.right, b.left);
    }

}
