package com.llx278.leetcode.ita;

import com.llx278.leetcode.datastruct.BinaryTreeNode;
import com.llx278.leetcode.datastruct.DataStructHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    @Test
    public void preOrderTest() {
        Tree t = new Tree();
        BinaryTreeNode<Integer> root = DataStructHelper.toBinaryTree(new Integer[] {9,8,7,6,5,4,3,2,1,0});
        List<BinaryTreeNode<Integer>> list  = new ArrayList<>();
        t.recursePreOrder(root,list);
        Integer[] excepted = new Integer[] {9,8,6,2,1,5,0,7,4,3};
        Assert.assertArrayEquals(excepted,DataStructHelper.toKeys(list).toArray(new Integer[1]));
        List<BinaryTreeNode<Integer>> list1 = new ArrayList<>();
        t.plainPreOrder(root,list1);
        Assert.assertArrayEquals(excepted,DataStructHelper.toKeys(list1).toArray(new Integer[1]));
    }

    @Test
    public void inOrderTest() {
        Tree t = new Tree();
        BinaryTreeNode<Integer> root = DataStructHelper.toBinaryTree(new Integer[] {9,8,7,6,5,4,3,2,1,0});
        List<BinaryTreeNode<Integer>> list  = new ArrayList<>();
        t.recurseInOrder(root,list);
        Integer[] excepted = new Integer[] {2,6,1,8,0,5,9,4,7,3};
        Assert.assertArrayEquals(excepted,DataStructHelper.toKeys(list).toArray(new Integer[1]));
        List<BinaryTreeNode<Integer>> list1 = new ArrayList<>();
        t.plainInOrder(root,list1);
        Assert.assertArrayEquals(excepted,DataStructHelper.toKeys(list1).toArray(new Integer[1]));
    }

    @Test
    public void postOrderTest() {
        Tree t = new Tree();
        BinaryTreeNode<Integer> root = DataStructHelper.toBinaryTree(new Integer[] {9,8,7,6,5,4,3,2,1,0});
        List<BinaryTreeNode<Integer>> list  = new ArrayList<>();
        t.recursePostOrder(root,list);
        Integer[] excepted = new Integer[] {2,1,6,0,5,8,4,3,7,9};

        Assert.assertArrayEquals(excepted,DataStructHelper.toKeys(list).toArray(new Integer[1]));
        List<BinaryTreeNode<Integer>> list1 = new ArrayList<>();
        t.plainPostOrder(root,list1);
        Assert.assertArrayEquals(excepted,DataStructHelper.toKeys(list1).toArray(new Integer[1]));
    }


}
