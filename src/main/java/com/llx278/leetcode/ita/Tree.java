package com.llx278.leetcode.ita;

import com.llx278.leetcode.datastruct.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// 实现对二叉树的遍历
// 前序遍历: 根节点 -> 左子树 -> 右子树
// 中序遍历: 左子树 -> 根节点 -> 右子树
// 后序遍历: 左子树 -> 右子树 -> 根节点
public class Tree {

    // 递归前序遍历
    public <T> void recursePreOrder(BinaryTreeNode<T> root, List<BinaryTreeNode<T>> list) {
        list.add(root);
        BinaryTreeNode<T> left = root.left;
        if (left != null) {
            recursePreOrder(left,list);
        }
        BinaryTreeNode<T> right = root.right;
        if (right != null) {
            recursePreOrder(right,list);
        }
    }

    // 非递归前序遍历
    public <T> void plainPreOrder(BinaryTreeNode<T> root,List<BinaryTreeNode<T>> list) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        // 根节点入栈
        stack.push(root);
        BinaryTreeNode<T> temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            // 访问节点
            //System.out.println(temp.val);
            list.add(temp);
            // 右子树入栈(因为是最后访问右子树)
            BinaryTreeNode<T> right = temp.right;
            if (right != null) {
                stack.push(right);
            }
            // 左子树入栈(因为是先访问左子树)
            BinaryTreeNode<T> left = temp.left;
            if (left != null) {
                stack.push(left);
            }
        }
    }

    // 递归中序遍历
    public <T> void recurseInOrder(BinaryTreeNode<T> root,List<BinaryTreeNode<T>> list) {
        BinaryTreeNode<T> left = root.left;
        if (left != null) {
            recurseInOrder(left,list);
        }
        //System.out.println(root.val);
        list.add(root);
        BinaryTreeNode<T> right = root.right;
        if (right != null) {
            recurseInOrder(right,list);
        }
    }

    // 非递归中序遍历
    public <T> void plainInOrder(BinaryTreeNode<T> root,List<BinaryTreeNode<T>> list) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        BinaryTreeNode<T> cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 左子树入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            //System.out.println(cur.val);
            list.add(cur);
            cur = cur.right;
        }
    }

    // 递归后序遍历
    public <T> void recursePostOrder(BinaryTreeNode<T> root,List<BinaryTreeNode<T>> list) {
        BinaryTreeNode<T> left = root.left;
        if (left != null) {
            recursePostOrder(left,list);
        }
        BinaryTreeNode<T> right = root.right;
        if (right != null) {
            recursePostOrder(right,list);
        }
        //System.out.println(root.val);
        list.add(root);
    }

    public <T> void plainPostOrder(BinaryTreeNode<T> root,List<BinaryTreeNode<T>> list) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        BinaryTreeNode<T> cur = root;
        BinaryTreeNode<T> top;
        BinaryTreeNode<T> visited=null;
        while (!stack.isEmpty() || cur != null) {
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
                //System.out.println(top.val);
                list.add(top);
                visited = top;
            } else {
                // 有右子树，继续遍历
                cur = top.right;
            }
        }
    }
}
