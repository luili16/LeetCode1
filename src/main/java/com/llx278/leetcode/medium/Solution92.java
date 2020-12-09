package com.llx278.leetcode.medium;

import com.llx278.leetcode.datastruct.ListNode;

public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode h = new ListNode(-1);
        h.next = head;
        h.val = -1;
        ListNode p0=null,p1 = null;
        int index = 0;
        while(index <= m) {
            if (p0 == null) {
                p1 = h;
                p0 = h;
            } else {
                p0 = p1;
                p1 = p1.next;
            }
            index++;
        }

        while (index <= n) {
            ListNode t = p1.next;
            if (t != null) {
                p1.next = t.next;
                t.next = p0.next;
                p0.next = t;
            }
            index++;
        }

        return h.next;
    }
}
