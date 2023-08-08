package com.LeetCode.Hot100._042_二叉树的最大深度_104;


import java.util.LinkedList;
import java.util.Queue;

class OfficialSolution {

    // 1. 深度优先搜索
    public int maxDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth_1(root.left);
            int rightHeight = maxDepth_1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // 2. 广度优先搜索, 和102题是一样的
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}

