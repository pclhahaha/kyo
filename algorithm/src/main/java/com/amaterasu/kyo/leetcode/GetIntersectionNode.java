package com.amaterasu.kyo.leetcode;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-15 15:44
 **/
public class GetIntersectionNode {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 第一时间想到的是：利用散列表来存储一个链表的遍历节点，再遍历另一个节点去散列表查询
     * <p>
     * 采用双指针，两个链表相加后长度一致，如果有相交点则一定会在后一段相交
     * 如果两个链表长度一致则在第一段就会相交
     * 如果两段遍历结束后都没有相交，说明没有相交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
