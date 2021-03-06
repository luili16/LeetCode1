package com.llx278.leetcode.datastruct;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DataStructHelperTest {

    @Test
    public void testRandomTree() {
        Node node = DataStructHelper.randomTree(3);
        // 怎么测试这个node是正确的？
        DataStructHelper.printTree(node);
    }


    @Test
    public void testCase () {
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = DataStructHelper.toLinkedList(nums);
        int[] ret = DataStructHelper.toArray(head);
        Assert.assertArrayEquals(nums,ret);
    }

}
