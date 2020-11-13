package com.llx278.leetcode.ita;

import com.llx278.leetcode.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 实现对树的遍历
// 前序遍历: 根节点 -> 左子树 -> 右子树
// 中序遍历: 左子树 -> 根节点 -> 右子树
// 后序遍历: 左子树 -> 右子树 -> 根节点
public class Tree {

    // 递归前序遍历
    public void recursePreOrder(TreeNode root) {
        System.out.println(root.val);
        TreeNode left = root.left;
        if (left != null) {
            recursePreOrder(left);
        }
        TreeNode right = root.right;
        if (right != null) {
            recursePreOrder(right);
        }
    }

    // 非递归前序遍历
    public void plainPreOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        // 根节点入栈
        stack.push(root);
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            // 访问节点
            System.out.println(temp.val);
            // 右子树入栈(因为是最后访问右子树)
            TreeNode right = temp.right;
            if (right != null) {
                stack.push(right);
            }
            // 左子树入栈(因为是先访问左子树)
            TreeNode left = temp.left;
            if (left != null) {
                stack.push(left);
            }
        }
    }

    // 递归中序遍历
    public void recurseInOrder(TreeNode root) {
        TreeNode left = root.left;
        if (left != null) {
            recurseInOrder(left);
        }
        System.out.println(root.val);
        TreeNode right = root.right;
        if (right != null) {
            recurseInOrder(right);
        }
    }

    // 非递归中序遍历
    public void plainInOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (!stack.isEmpty() && cur != null) {
            // 左子树入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    // 递归后序遍历
    public void recursePostOrder(TreeNode root) {
        TreeNode left = root.left;
        if (left != null) {
            recursePostOrder(root);
        }
        TreeNode right = root.right;
        if (right != null) {
            recursePostOrder(right);
        }
        System.out.println(root.val);
    }

    public void plainPostOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode top;
        TreeNode visited=null;
        while (!stack.isEmpty() && cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 除非右子树为空，否则不能直接遍历
            top = stack.peek();
            // 判断右子树是不是空，如果是空，那么打印结果
            // 如果没有右子树或者这个节点已经遍历过了，元素出栈
            if (top.right == null || top.right == visited) {
                stack.pop();
                System.out.println(top.val);
                visited = top;
            } else {
                // 有右子树，继续遍历
                cur = stack.pop();
            }
        }
    }
}
