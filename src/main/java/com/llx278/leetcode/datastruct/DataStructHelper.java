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

    public static TreeNode ToBinaryTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int p = parent(i);
            if (p > 0 && nodes[p] == null) {
                nodes[p] = new TreeNode(nums[p]);
            }
            int l = left(i);
            if (l < nums.length) {
                nodes[p].left = new TreeNode(nums[l]);
            }
            int r = right(i);
            if (r < nums.length) {
                nodes[p].right = new TreeNode(nums[r]);
            }
        }
        return root;
    }

    private static int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    private static int left(int i) {
        return (i + 1) * 2 - 1;
    }

    private static int right(int i) {
        return ((i + 1) * 2 + 1) - 1;
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
