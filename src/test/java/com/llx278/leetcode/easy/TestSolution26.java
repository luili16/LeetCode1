package com.llx278.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class TestSolution26 {

    Solution26 solution26;

    @Before
    public void setup() {
        solution26 = new Solution26();
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,1,2};
        int ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(2,ret);
        Assert.assertArrayEquals(new int[]{1,2}, Arrays.copyOfRange(nums,0,ret));
    }

    @Test
    public void test1() {
        int ret;

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(5,ret);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4},Arrays.copyOfRange(nums,0,ret));


        nums = new int[]{0,0,1,1,1,2,2,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(5,ret);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{1,2,3,4,5,6};
        ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(6,ret);
        Assert.assertArrayEquals(new int[]{1, 2,3,4,5,6},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{1,2};
        ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(2,ret);
        Assert.assertArrayEquals(new int[]{1, 2},Arrays.copyOfRange(nums,0,ret));

    }

    @Test
    public void test2() {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,1};
        int ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(2,ret);
        Assert.assertArrayEquals(new int[]{0, 1},Arrays.copyOfRange(nums,0,ret));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
        int ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(1,ret);
        Assert.assertArrayEquals(new int[]{0},Arrays.copyOfRange(nums,0,ret));
    }

    @Test
    public void test4() {
        int[] nums= new int[] {0};
        int ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(1,ret);
        Assert.assertArrayEquals(new int[]{0},Arrays.copyOfRange(nums,0,ret));
    }

    @Test
    public void test5() {
        int[] nums= new int[] {};
        int ret = solution26.removeDuplicates(nums);
        Assert.assertEquals(0,ret);
        Assert.assertArrayEquals(new int[]{},Arrays.copyOfRange(nums,0,ret));
    }


}
