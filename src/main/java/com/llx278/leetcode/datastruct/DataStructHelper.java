package com.llx278.leetcode.datastruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataStructHelper {

    private static final int MAX_CHILDREN_COUNT = 3;


    public static void printTree(Node header) {
        printTreeRecurse(header,1);
    }

    private static void printTreeRecurse(Node node, int deep) {
        System.out.println("value: " + node.val + " deep: " + deep);
        if (node.children == null) {
            return;
        }

        for (Node n : node.children) {
            printTreeRecurse(n,deep + 1);
        }
    }

    public static Node randomTree(int deep) {
        Random random = new Random();
        int value = random.nextInt(20);
        // 第一层
        Node header = new Node(value);
        // 第二层
        randomTreeRecurse(header,2, deep);
        return header;
    }

    private static void randomTreeRecurse(Node node,int deep,int max) {

        if (deep > max) {
            return;
        }

        Random random = new Random();
        int count = random.nextInt(MAX_CHILDREN_COUNT);
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int value = random.nextInt(20);
            Node child = new Node(value);
            children.add(child);
            randomTreeRecurse(child,deep + 1, max);
        }
        node.children = children;
    }

    public static Node ToBinaryTree(int[] nums) {
        throw new RuntimeException();
    }

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
