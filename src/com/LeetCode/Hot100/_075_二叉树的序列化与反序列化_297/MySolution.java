package com.LeetCode.Hot100._075_二叉树的序列化与反序列化_297;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


//20221116
class MySolution {

}


class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(temp.val));
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
        return res.toString().replace(" ", "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int n = list.length, position = 0;
        TreeNode root = Objects.equals(list[0], "null") ? null : new TreeNode(Integer.parseInt(list[0]));
        q.add(root);
        while (position < n - 2) {
            TreeNode temp = q.poll();
            if (!Objects.equals(list[position + 1], "null")) {
                temp.left = new TreeNode(Integer.parseInt(list[position + 1]));
                q.add(temp.left);
            }
            if (!Objects.equals(list[position + 2], "null")) {
                temp.right = new TreeNode(Integer.parseInt(list[position + 2]));
                q.add(temp.right);
            }
            position += 2;
        }
        return root;
    }
}