package com.amaterasu.kyo.leetcode;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-30 20:35
 **/
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) return false;
        if (root2 == null && root1 != null) return false;
        if (root2 == null && root1 == null) return true;
        if (root1.val != root2.val) return false;
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
