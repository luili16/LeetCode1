package com.llx278.leetcode.sort;

import java.util.Random;

// 快速排序(随机版本)
public class QuickSortRandom implements Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums,0,nums.length - 1);
    }

    @Override
    public void sort(int[] nums, int begin, int offset) {
        quickSort(nums,begin,offset);
    }

    private int partition(int[] nums,int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= x) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int s= i + 1;
        int temp = nums[s];
        nums[s] = nums[r];
        nums[r] = temp;
        return s;
    }

    private int randomPartition(int[] nums,int p, int r) {
        Random random = new Random();
        int n = r - p + 1;
        int i = random.nextInt(n) + p;
        int temp = nums[r];
        nums[r] = nums[i];
        nums[i] = temp;
        return partition(nums,p,r);
    }

    private void quickSort(int[] nums,int p,int r) {
        if (p < r) {
            int q = randomPartition(nums,p,r);
            quickSort(nums,p,q-1);
            quickSort(nums,q + 1,r);
        }
    }
}
