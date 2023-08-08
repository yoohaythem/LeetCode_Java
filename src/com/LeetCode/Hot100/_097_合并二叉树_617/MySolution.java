package com.LeetCode.Hot100._097_合并二叉树_617;


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


//20221123
class MySolution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            TreeNode sum = new TreeNode();
            sum.val = root1.val + root2.val;
            sum.left = mergeTrees(root1.left, root2.left);
            sum.right = mergeTrees(root1.right, root2.right);
            return sum;
        } else if (root1 == null) {
            return root2;
        } else {
            return root1;
        }
    }
}
