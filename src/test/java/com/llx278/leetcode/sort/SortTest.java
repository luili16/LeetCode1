package com.llx278.leetcode.sort;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    private Sort sort = new ShellSort();

    @Test
    public void test(){
        int[] nums = new int[] {5,2,4,6,1,3};
        sort.sort(nums);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},nums);

        nums = new int[]{5,2,4,6,1,3};
        sort.sort(nums,0,nums.length - 1);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},nums);
    }

    @Test
    public void test1() {
        int[] nums = new int[]{};
        sort.sort(nums);
        Assert.assertArrayEquals(new int[]{},nums);


//        nums = new int[]{};
//        sort.sort(nums,0,nums.length - 1);
//        Assert.assertArrayEquals(new int[]{},nums);

    }

    @Test
    public void test2() {
        int[] nums = new int[]{1};
        sort.sort(nums);
        Assert.assertArrayEquals(new int[]{1},nums);

        nums = new int[]{1};
        sort.sort(nums,0,nums.length - 1);
        Assert.assertArrayEquals(new int[]{1},nums);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1,2,3,4,5,5,5,6};
        sort.sort(nums);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,5,5,6},nums);

        nums = new int[]{1,2,3,4,5,5,5,6};
        sort.sort(nums,0,nums.length - 1);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,5,5,6},nums);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{6,5,4,3,2,1};
        sort.sort(nums);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},nums);

        nums = new int[]{6,5,4,3,2,1};
        sort.sort(nums,0,nums.length - 1);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},nums);
    }

    @Test
    public void test5() {
        int[] nums = new int[]{5,7,8,3,1,2,4,6};
        sort.sort(nums);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},nums);

        nums = new int[]{5,7,8,3,1,2,4,6};
        sort.sort(nums,0,nums.length - 1);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},nums);
    }
}
