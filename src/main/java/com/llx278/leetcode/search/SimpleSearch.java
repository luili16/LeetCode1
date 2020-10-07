package com.llx278.leetcode.search;

public class SimpleSearch implements Search {
    @Override
    public int search(int value, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (value == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
