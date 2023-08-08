package com.LeetCode.Hot100._088_路径总和III_437;


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


//20221121
class MySolution {

    // 1. 递归
    public int withRoot(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        return (root.val == targetSum ? 1 : 0) + withRoot(root.left, targetSum - root.val) + withRoot(root.right, targetSum - root.val);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + withRoot(root, targetSum);
    }


    // 2. 前缀和
    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        curr += root.val;  // 截止到当前节点的前缀和
        int result = prefix.getOrDefault(curr - targetSum, 0);  // 截止到当前节点的有效路径数量
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        result += dfs(root.left, prefix, curr, targetSum);
        result += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return result;
    }

    public int pathSum_2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();  // 该数组存储的是，前缀为 key 的路径一共有 value 个
        prefix.put(0L, 1);
        return dfs(root, prefix, 0L, targetSum);
    }

}
