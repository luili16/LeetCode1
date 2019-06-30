package com.llx278.leetcode.easy;

public class Solution26 {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int p = 0;
        int q = 1;
        for (int i = 0; i < nums.length; i++) {
            if (q >= nums.length) {
                break;
            }

            if (nums[q] != nums[p]) {
                // 交换p + 1 与 r
                int r = p + 1;
                int temp = nums[r];
                nums[r] = nums[q];
                nums[q] = temp;
                p++;
                q++;
            } else {
                q++;
            }
        }

        return p + 1;
    }
}
