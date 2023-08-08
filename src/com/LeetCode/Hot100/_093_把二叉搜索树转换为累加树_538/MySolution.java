package com.LeetCode.Hot100._093_把二叉搜索树转换为累加树_538;


import java.util.*;

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
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode n = root;
        int sum = 0;
        while (!stack.isEmpty() || n != null) {
            while (n != null) {
                stack.push(n);
                n = n.right;
            }
            n = stack.pop();
            sum += n.val;
            n.val = sum;
            n = n.left;
        }
        return root;
    }
}
