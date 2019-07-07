package com.llx278.leetcode.medium;


import com.llx278.leetcode.datastruct.ListNode;

/**
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {

        ListNode t = head;
        ListNode tp = null;
        ListNode p0 = head;
        ListNode p1 = head;
        while (t != null) {
            if (t.val < x) {
                // 先处理好tp和t的位置关系
                ListNode temp = t;
                if (tp == null) {
                    // 头结点
                    tp = t;
                    t = t.next;
                } else {
                    tp.next = t.next;
                    t = t.next;
                }

                // 待插入的节点是temp
                // p0始终指向左分区链表的头部
                // p1始终指向右分区链表的头部
                if (p0 == p1) {
                    // 第一次初始化
                    p0 = temp;
                    temp.next = p1;
                } else {
                    // 从p0向右找到第一个比temp.val大的节点
                    ListNode pre = null;
                    ListNode pz = p0;
                    while (pz != p1) {
                        if (pz.val > temp.val) {
                            if (pre == null) {
                                // 这是首节点
                                temp.next = p0;
                                p0 = temp;
                            } else {
                                temp.next = pre.next;
                                pre.next = temp;
                            }
                            break;
                        }
                        pre = pz;
                        pz = pz.next;
                    }
                }
            } else {
                tp = t;
                t = t.next;
            }
        }
        return p0;
    }
}
