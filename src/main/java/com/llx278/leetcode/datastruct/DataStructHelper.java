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

    public static <T> List<Integer> toKeys(List<BinaryTreeNode<T>> nodes) {
        List<Integer> i = new ArrayList<>();
        nodes.forEach(tBinaryTreeNode -> {
            i.add(tBinaryTreeNode.key);
        });
        return i;
    }

    public static <T> BinaryTreeNode<T> toBinaryTree(Integer[] nums) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T>[] nodes = new BinaryTreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nodes[i] == null && nums[i] != null) {
                nodes[i] = new BinaryTreeNode<>(nums[i]);
            }

            int l = left(i);
            if (l < nums.length && nums[l] != null && nodes[i] != null) {
                if (nodes[l] == null) {
                    nodes[l] = new BinaryTreeNode<>(nums[l]);
                }
                // 左子树存在
                nodes[i].left = nodes[l];
            }

            int r = right(i);
            if (r < nums.length && nums[r] != null && nodes[i] != null) {
                if (nodes[r] == null) {
                    nodes[r] = new BinaryTreeNode<>(nums[r]);
                }
                // 右子树存在
                nodes[i].right = nodes[r];
            }
        }
        return nodes[0];
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
