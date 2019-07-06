package com.llx278.leetcode.datastruct;

import java.util.ArrayList;
import java.util.List;

public class DataStructHelper {

    public  static ListNode toLinkedList(int[] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return head;
    }

    public static int[] toArray(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
