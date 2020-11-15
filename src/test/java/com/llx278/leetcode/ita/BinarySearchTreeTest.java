package com.llx278.leetcode.ita;

import com.llx278.leetcode.datastruct.BinaryTreeNode;
import com.llx278.leetcode.datastruct.DataStructHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void printBinarySearchTree() {
        Integer[] searchTree = new Integer[] {
                12,
                5,
                18,
                2,
                9,
                15,
                19,
                null,
                null,
                null,
                null,
                null,
                17
        };
        BinaryTreeNode<Integer> n = DataStructHelper.toBinaryTree(searchTree);
        Tree tree = new Tree();
        List<BinaryTreeNode<Integer>> list = new ArrayList<>();
        tree.recurseInOrder(n,list);
        System.out.println(list.toString());
    }
}
