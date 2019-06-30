package com.llx278.leetcode.medium;

public class Solution80 {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int p = 0;
        boolean tag = false;
        for (int q = 1; q < nums.length; q++) {

            if (nums[p] != nums[q]) {
                tag = false;
                p++;
                nums[p] = nums[q];
            } else {
                if (!tag) {
                    tag = true;
                    p++;
                    nums[p] = nums[q];
                }
            }
        }
        return p + 1;
    }
}
