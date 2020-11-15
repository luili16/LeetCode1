package com.llx278.leetcode.datastruct;

/**
 * 二叉树节点
 * @param <T>
 */
public class BinaryTreeNode<T> {
    public final T val;
    public final int key;
    public BinaryTreeNode<T> parent = null;
    public BinaryTreeNode<T> left = null;
    public BinaryTreeNode<T> right = null;
    public BinaryTreeNode(int key, T val) {
        this.key = key;
        this.val = val;
    }

    public BinaryTreeNode(int key) {
        this(key,null);
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
