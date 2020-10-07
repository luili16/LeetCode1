package com.llx278.leetcode.sort;

// 希尔排序
public class ShellSort implements Sort {


    @Override
    public void sort(int[] nums) {
        int span = nums.length / 2;
        while (span >= 1) {
            int div = nums.length / span + (nums.length % span > 0 ? 1 : 0);
            int[] pointer = new int[div];
            for (int i = 0; i < span; i++) {
                int j = i;
                int k = 0;
                while (j < nums.length) {
                    pointer[k] = j;
                    j += span;
                    k++;
                }
                insertSort(nums, pointer);
            }
            span--;
        }
    }

    @Override
    public void sort(int[] nums, int begin, int offset) {
        if (!(offset - begin + 1 <= nums.length && begin >=0 && offset >=0)) {
            throw new IllegalArgumentException("offset:" + offset + " begin:" + begin + " nums.length:" + nums.length);
        }
        int len = offset - begin + 1;
        int span = len / 2;
        while (span >= 1) {
            int div = len / span + (len % span > 0? 1: 0);
            int[] pointer = new int[div];
            for (int i = 0; i < span; i++) {
                int j = i;
                int k = 0;
                while (j < len) {
                    pointer[k] = j;
                    j += span;
                    k++;
                }
                insertSort(nums,pointer);
            }
            span--;
        }
    }

    private void insertSort(int[] nums, int[] pointer) {
        for (int i = 1; i < pointer.length; i++) {
            int m = nums[pointer[i]];
            for (int j = 0; j < i; j++) {
                int n = nums[pointer[j]];
                if (n > m) {
                    for (int k = i - 1; k >= j; k--) {
                        nums[pointer[k + 1]] = nums[pointer[k]];
                    }
                    nums[pointer[j]] = m;
                    break;
                }
            }
        }
    }
}
