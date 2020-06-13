package com.amaterasu.kyo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-31 13:45
 **/
public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode res = null, next = null;
        for (ListNode node : lists) {
            if (node != null) priorityQueue.add(node);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            if (res == null) {
                res = node;
                next = node;
            } else {
                next.next = node;
                next = next.next;
            }
            if (node.next != null) priorityQueue.add(node.next);
        }
        return res;
    }


}
