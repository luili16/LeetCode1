package com.llx278.leetcode.sort;

/**
 * 插入排序
 */
public class InsertionSort implements Sort {

    /**
     * 总执行次数:
     *  c1*n + c2*(n-1) + c4*(n-1) + c5*(2+3+...+n) + c6*(2+3+...+n - 1) + c7*(2+3+...+n - 1) + c8*(n - 1)
     *  = c1*n + c2*(n-1) + c4*(n - 1) + c5*(n(n+1)/2 - 1) + c6*(n*(n-1)/2) + c7*(n*(n-1)/2)
     *
     */
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) { // n            c1
            int key = nums[i];                  // n - 1            c2
            int j = i - 1;                      // n - 1            c4
            while (j >= 0 && nums[j] > key) {   // 2 + 3 + ... + n  c5
                nums[j + 1] = nums[j];         // 2 + ... + n-1   c6   相对上一行少执行了一步
                j--;                          // 2 + ... + n-1    c7
            }
            nums[j + 1] = key;               // n - 1               c8
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
