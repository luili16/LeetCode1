package com.llx278.leetcode.sort;

/**
 * 插入排序
 */
public class InsertionSort implements Sort {

    /**
     * 总执行次数:
     *  c1*n + c2*(n-1) + c3*(n-1) + c4*(2+3+...+n)
     */
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) { // n            c1
            int key = nums[i];                  // n - 1            c2
            int j = i - 1;                      // n - 1            c3
            while (j >= 0 && nums[j] > key) {   // 2 + 3 + ... + n  c4
                nums[j + 1] = nums[j];         // 2 + 3 + ... + n   c5
                j--;                          // 2 + 3 + ... + n    c6
            }
            nums[j + 1] = key;               // n - 1               c7
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
