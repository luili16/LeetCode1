package com.llx278.leetcode.ita;

import com.llx278.leetcode.datastruct.BinaryTreeNode;

// 二叉搜索树
public class BinarySearchTree<T> {

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
            cur.left = z;
        } else {
            cur.right = z;
        }
    }

    // 删除一个节点
    public static <T> void delete(BinaryTreeNode<T> z) {

        if (z.left == null && z.right == null) {
            transplant(z.parent,null);
            return;
        }

        if (z.left == null) {
            // 节点z没有左孩子，那么就直接用节点z的右孩子替换z节点
            transplant(z,z.right);
            return;
        }

        if (z.right == null) {
            // 同上
            transplant(z,z.left);
        }

        // z节点的左右孩子都存在
        // 1. 先找到z节点右孩子的最小节点(比z节点要大的那个最小的节点)
        BinaryTreeNode<T> y = minimum(z.right);
        // 2. 让y占据树中z的位置
        // y不是z的直接后继(y不是z的右孩子)
        if (y.parent != z) {
            transplant(y,y.right);
            y.right = z.right;
            y.right.parent = y;
        }
        transplant(z,y);
        y.left = z.left;
        y.left.parent = y;
    }

    /**
     * 用一个v为根的子树来替换一颗以u为根的子树
     * @param u 被替换的节点
     * @param v v
     * @param <T> data
     */
    public static <T> void transplant(BinaryTreeNode<T> u,BinaryTreeNode<T> v) {
        if (u.parent == null) {
            // 不处理根节点是空的情况
            throw new RuntimeException("root can not be null");
        }

        if (u == u.parent.left) {
            // u是左节点
            u.parent.left = v;
        } else {
            // u是右节点
            u.parent.right = v;
        }

        if (v != null) {
            v.parent = u.parent;
        }
    }
}
