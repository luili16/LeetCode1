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
}
