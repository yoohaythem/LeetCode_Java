package com.LeetCode.Hot100._041_二叉树的层序遍历_102;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                root = q.poll();
                if (root != null) {
                    layer.add(root.val);
                    q.offer(root.left);
                    q.offer(root.right);
                }
            }
            if (!layer.isEmpty()){
                result.add(new ArrayList<>(layer));
            }
        }
        return result;
    }
}
