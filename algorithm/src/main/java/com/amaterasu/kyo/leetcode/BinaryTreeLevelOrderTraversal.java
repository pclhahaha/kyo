package com.amaterasu.kyo.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-30 20:44
 **/
public class BinaryTreeLevelOrderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node);
                list1.add(node.val);
            }
            res.add(list1);
            for (TreeNode node : list) {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}
