package com.LeetCode.Hot100._043_从前序与中序遍历序列构造二叉树_105;


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
    public int[] subint(int[] arr, int start, int end) {
        int n = arr.length;
        if (start < 0) {
            start = 0;
        }
        if (end > n) {
            end = n;
        }
        if (start > end) {
            end = start;
        }
        int[] newarr = new int[end - start];
        for (int i = start; i < end; i++) {
            newarr[i - start] = arr[i];
        }
        return newarr;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {     //这里应该纪录下标位置，而不是复制数组
        int n = preorder.length, flag = 0;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                flag = i;
                break;
            }
        }
        // 左子树     前序：preorder 1<=x<=flag    中序：inorder  0<=x<flag
        // 右子树     前序：preorder  flag<x<n     中序：inorder  flag<x<n
        root.left = buildTree(subint(preorder, 1, flag + 1), subint(inorder, 0, flag));
        root.right = buildTree(subint(preorder, flag + 1, n), subint(inorder, flag + 1, n));

        return root;
    }

}
