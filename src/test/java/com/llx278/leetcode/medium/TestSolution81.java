package com.llx278.leetcode.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSolution81 {

    Solution81 solution81;

    @Before
    public void setUp() {
        solution81 = new Solution81();
    }

    @Test
    public void testCase0() {
        int[] data = new int[]{2,2,3,3,3,3,4,4,4,4,5,5,5,6,0,0,0,0,1,1,1,1,2,2};
        Assert.assertTrue(solution81.search(data,4));
        data = new int[]{2,3};
        Assert.assertTrue(solution81.search(data,3));
        Assert.assertTrue(solution81.search(data,2));
        Assert.assertFalse(solution81.search(data,4));
        data = new int[]{};
        Assert.assertFalse(solution81.search(data,11));
        data = null;
        Assert.assertFalse(solution81.search(data,2));
        data = new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        Assert.assertTrue(solution81.search(data,2));
        Assert.assertFalse(solution81.search(data,3));
        data = new int[]{2,3,4,5,6,7,8,9};
        Assert.assertTrue(solution81.search(data,9));
        Assert.assertTrue(solution81.search(data,3));
        data = new int[]{9,8,7,6,5,4,3,2};
        Assert.assertTrue(solution81.search(data,9));
        data = new int[]{4,5,6,7,0,1,2};
        Assert.assertTrue(solution81.search(data,1));
    }

}