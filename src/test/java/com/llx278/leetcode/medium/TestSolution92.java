package com.llx278.leetcode.medium;

import com.llx278.leetcode.datastruct.DataStructHelper;
import com.llx278.leetcode.datastruct.ListNode;
import org.junit.Test;

import java.util.Arrays;

public class TestSolution92 {

    @Test
    public void test() {
        Solution92 s92 = new Solution92();
        ListNode head = DataStructHelper.toLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode n = s92.reverseBetween(head,2,4);
        System.out.println(Arrays.toString(DataStructHelper.toArray(n)));
    }
}
