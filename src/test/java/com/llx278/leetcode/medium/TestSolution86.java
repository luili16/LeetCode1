package com.llx278.leetcode.medium;

import com.llx278.leetcode.datastruct.DataStructHelper;
import com.llx278.leetcode.datastruct.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSolution86 {

    Solution86 solution86;

    @Before
    public void setUp() {
        solution86 = new Solution86();
    }

    @Test
    public void testCase() {
        ListNode head = DataStructHelper.toLinkedList(new int[]{1,4,3,2,5,2});

        ListNode ret = solution86.partition(head,3);
        int[] nums = DataStructHelper.toArray(ret);
        Assert.assertArrayEquals(new int[]{1,2,2,4,3,5},nums);
    }
}
