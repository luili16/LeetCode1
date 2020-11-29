package com.llx278.leetcode.medium;

import org.junit.Test;

import java.util.List;

public class TestSolution78 {

    @Test
    public void test() {
        Solution78 solution78 = new Solution78();
        List<List<Integer>> lists = solution78.subSets(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}
