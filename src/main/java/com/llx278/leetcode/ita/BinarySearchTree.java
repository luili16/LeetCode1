package com.llx278.leetcode.ita;

import com.llx278.leetcode.datastruct.BinaryTreeNode;

// 二叉搜索树
public class BinarySearchTree {

    // 查找
    public static  <T> BinaryTreeNode<T> search(BinaryTreeNode<T> root, int key) {

        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left,key);
        } else {
            return search(root.right,key);
        }
    }

    // 查找(非递归实现)
    public static  <T> BinaryTreeNode<T> iterativeSearch(BinaryTreeNode<T> root, int key) {
        BinaryTreeNode<T> cur = root;
        while (cur != null && cur.key != key) {
            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

    // 最小关键字
    public static <T> BinaryTreeNode<T> minimum(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    // 最大关键字
    public static <T> BinaryTreeNode<T> maximum(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    // 按照中序遍历次序查找指定节点的后继
    public static <T> BinaryTreeNode<T> successor(BinaryTreeNode<T> x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        BinaryTreeNode<T> cur = x;
        BinaryTreeNode<T> parent = cur.parent;
        while (parent != null && cur == parent.right) {
            cur = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // 插入一个节点
    public static <T> void insert(BinaryTreeNode<T> root, BinaryTreeNode<T> z) {
        if (root == null) {
            return;
        }

        BinaryTreeNode<T> cur = null;
        BinaryTreeNode<T> x = root;
        while (x != null) {
            cur = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = cur;
        if (z.key < cur.key) {
            // 坐标
            cur.left = z;
        } else {
            cur.right = z;
        }
    }

    // 删除一个节点
    public static <T> void delete(BinaryTreeNode<T> root, BinaryTreeNode<T> z) {
    }
}
