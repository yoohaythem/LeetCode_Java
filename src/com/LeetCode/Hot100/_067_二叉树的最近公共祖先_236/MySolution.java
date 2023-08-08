package com.LeetCode.Hot100._067_二叉树的最近公共祖先_236;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


//20221115
class MySolution {

    TreeNode result;

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {   // 包含 p 或者 q 就返回 true
        if (node == null) {
            return false;
        }
        boolean inLeft = dfs(node.left, p, q);
        boolean inRight = dfs(node.right, p, q);
        boolean inCurrentNode = node.val == p.val || node.val == q.val;

        if ((inLeft && inRight) || (inCurrentNode && (inLeft || inRight))) {
            result = node;
        }

        return inLeft || inRight || inCurrentNode;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return this.result;
    }
}
