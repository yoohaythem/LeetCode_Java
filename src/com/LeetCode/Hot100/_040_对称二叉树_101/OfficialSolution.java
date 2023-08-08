package com.LeetCode.Hot100._040_对称二叉树_101;


import java.util.LinkedList;
import java.util.Queue;

class OfficialSolution {

    // 1. 递归
    public boolean isSymmetric_1(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    // 2. 迭代
    public boolean isSymmetric_2(TreeNode root) {
        return check_2(root, root);
    }

    public boolean check_2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();   // 单向链表，是队列不是栈
        q.offer(u);   // 将指定的元素添加到集合结尾
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();      // poll--返回并删除；peek--返回不删除。
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}

