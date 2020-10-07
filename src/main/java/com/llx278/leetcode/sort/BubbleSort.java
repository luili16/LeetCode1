package com.llx278.leetcode.sort;


// 冒泡排序
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0;j < i; j++) {
                if (nums[j] >= nums[j + 1]) {
                    int temp= nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sort(int[] nums, int begin, int offset) {
        if (offset - begin + 1 > nums.length) {
            throw new IndexOutOfBoundsException("offset - begin + 1 > nums.length begin:"+begin + " offset:"+offset + " length:"+nums.length);
        }
        for (int i = offset; i > begin; i--) {
            for (int j = begin;j < i; j++) {
                if (nums[j] >= nums[j + 1]) {
                    int temp= nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
