package com.llx278.leetcode.medium;

import org.junit.Test;

import java.util.List;

public class TestSolution90 {

    private final Solution90 solution90 = new Solution90();

    @Test
    public void testCase() {
        List<List<Integer>> lists = solution90.subsetsWithDup(new int[]{2,1,2,1,3});
        System.out.println(lists);
    }

}
