package com.llx278.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class TestSolution80 {

    Solution80 solution80;
    @Before
    public void setup() {
        solution80= new Solution80();
    }

    @Test
    public void testCase0() {
        int[] nums = new int[]{0,0,0,1,1,1,1,2,2,3,3,3};
        int ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2,3,3}, Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{0,1,2,3};
        ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{0,0,1,2,3};
        ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new int[]{0,0,1,2,3},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{1,1,1,2,2,3};
        ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new  int[]{1,1,2,2,3},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,3,3},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{};
        ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new int[]{},Arrays.copyOfRange(nums,0,ret));

        nums = new int[]{0,0,1,1,2,2,3,3};
        ret = solution80.removeDuplicates(nums);
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2,3,3},Arrays.copyOfRange(nums,0,ret));
    }
}
