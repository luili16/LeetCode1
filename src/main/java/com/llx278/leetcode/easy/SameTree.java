package com.llx278.leetcode.easy;


import com.llx278.leetcode.datastruct.BinaryTreeNode;

public class SameTree {

    public static class BooleanWrapper {
        boolean isSame;
    }

    public boolean isSameTree(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        BooleanWrapper w = new BooleanWrapper();
        w.isSame = true;
        travalTrees(p, q, w);
        return w.isSame;
    }

    private void travalTrees(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q, BooleanWrapper w) {

        if (p == null && q == null) {
            return;
        }

        if (p == null || q == null) {
            System.out.println("is not Same 1");
            w.isSame = false;
            return;
        }

        if (p.val != q.val) {
            w.isSame = false;
            System.out.println("is not Same 2");
            return;
        }

        travalTrees(p.left, q.left, w);
        if (!w.isSame) {
            return;
        }
        travalTrees(p.right, q.right, w);

    }

}
