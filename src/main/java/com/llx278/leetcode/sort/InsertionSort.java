package com.llx278.leetcode.sort;

/**
 * 插入排序
 */
public class InsertionSort implements Sort {

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int k = i - 1;
            while (k >= 0 && nums[k] > key) {
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = key;
        }
    }

    @Override
    public void sort(int[] nums, int begin, int offset) {
        if (!(offset - begin + 1 <= nums.length && begin >=0 && offset >=0)) {
            throw new IllegalArgumentException("offset:" + offset + " begin:" + begin + " nums.length:" + nums.length);
        }
        int len = offset - begin + 1;
        for (int i = begin + 1; i < len; i++) {
            int key = nums[i];
            int k = i - 1;
            while (k >= begin && nums[k] > key) {
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = key;
        }
    }
}
