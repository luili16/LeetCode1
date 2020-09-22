package com.llx278.leetcode.sort;

/**
 * 插入排序
 */
public class InsertionSort implements Sort {

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            for (int j = 0; j < i; j++) {
                int a = nums[j];
                if (a > key) {
                    // insert i to j
                    int temp = nums[i];
                    for (int k = i - 1; k >= j; k--) {
                        nums[k + 1] = nums[k];
                    }
                    nums[j] = temp;
                    break;
                }
            }
        }
    }
}
