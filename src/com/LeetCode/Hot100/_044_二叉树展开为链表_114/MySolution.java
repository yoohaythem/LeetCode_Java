package com.LeetCode.Hot100._044_二叉树展开为链表_114;


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


//20221107
class MySolution {

    // 1. 前序遍历
    public void flatten_1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> sorted = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                sorted.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        sorted.add(null);

        for (int i = 0; i < sorted.size() - 1; i++) {
            sorted.get(i).left = null;
            sorted.get(i).right = sorted.get(i + 1);
        }
    }

    // 2. 寻找前驱节点
    public void flatten_2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left, pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


}
