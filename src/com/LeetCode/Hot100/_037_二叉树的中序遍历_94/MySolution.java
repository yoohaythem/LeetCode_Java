package com.LeetCode.Hot100._037_二叉树的中序遍历_94;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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


//20221105
class MySolution {

    // 1. 递归
    public List<Integer> inorderTraversal_1(TreeNode root) {
        return myfunc(root, new ArrayList<>());
    }

    public List<Integer> myfunc(TreeNode root, List<Integer> lst) {
        if (root == null) {
            return lst;
        }
        lst = myfunc(root.left, lst);
        lst.add(root.val);
        lst = myfunc(root.right, lst);
        return lst;
    }


    // 2. 迭代
    public List<Integer> inorderTraversal_2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
