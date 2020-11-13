package com.llx278.leetcode.datastruct;

public class DoubleLinkedList {

    public ListDoubleNode head;

    // 在双向链表里面查找关键字为k的对象
    public static ListDoubleNode search(DoubleLinkedList l, int k) {

        ListDoubleNode x = l.head;

        while (x != null && x.key != k) {
            x = x.next;
        }
        return x;
    }

    // 插入到链表的前端
    public static void insert(DoubleLinkedList l,ListDoubleNode x) {
        x.next = l.head;
        if (l.head != null) {
            l.head.pre = x;
        }
        l.head = x;
        x.pre = null;
    }

    // 从链表l中删除x
    public static void delete(DoubleLinkedList l, ListDoubleNode x) {
        if (x.pre != null) {
            x.pre.next = x.next;
        } else {
            // 是头结点
            l.head = x.next;
        }
        if (x.next != null) {
            x.next.pre = x.pre;
        }
    }
}
