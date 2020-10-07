package com.llx278.leetcode.sort;

// 选择排序
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int n = nums[i];
            int p = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= n) {
                    n = nums[j];
                    p = j;
                }
            }
            // p指向最小的那个
            int temp = nums[p];
            nums[p] = nums[i];
            nums[i] = temp;
        }
    }

    @Override
    public void sort(int[] nums, int begin, int offset) {

        if (!(offset - begin + 1 <= nums.length && begin >=0 && offset >=0)) {
            throw new IllegalArgumentException("offset:" + offset + " begin:" + begin + " nums.length:" + nums.length);
        }

        int len = offset - begin + 1;
        for (int i = begin; i < len - 1; i++) {
            int n = nums[i];
            int p = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] <= n) {
                    n = nums[j];
                    p = j;
                }
            }
            // p指向最小的那个
            int temp = nums[p];
            nums[p] = nums[i];
            nums[i] = temp;
        }
    }
}
