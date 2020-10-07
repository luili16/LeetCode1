package com.llx278.leetcode.sort;

// 归并排序(快速排序)
public class MergeSort implements Sort {


    @Override
    public void sort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        mergeSort(0,nums.length -1, nums);
    }

    @Override
    public void sort(int[] nums, int begin, int offset) {
        if (!(offset - begin + 1 <= nums.length && begin >=0 && offset >=0)) {
            throw new IllegalArgumentException("offset:" + offset + " begin:" + begin + " nums.length:" + nums.length);
        }
        mergeSort(begin,offset,nums);
    }

    private void mergeSort(int b, int e,int[] nums) {

        int len = e - b + 1;
        if (len <= 1) {
            return;
        }
        // 0 1 2 3 len == 4
        // s= 2
        int s = len / 2 + b - 1;
        int s1 = s + 1;
        // s = 1
        // b - s  s1 - e

        mergeSort(b,s,nums);
        mergeSort(s1,e,nums);

        int p = s - b + 1;
        int q = e - s1 + 1;

        int[] temp = new int[len];
        int r = 0;
        int i = 0;
        int j = 0;
        while (i < p && j < q) {
            if (nums[b + i] < nums[s1 + j]) {
                temp[r] = nums[b + i];
                r++;
                i++;
            } else {
                temp[r] = nums[s1 + j];
                r++;
                j++;
            }
        }

        // 拷贝剩余的
        while (i < p) {
            temp[r] = nums[b + i];
            i++;
            r++;
        }
        while (j < q) {
            temp[r] = nums[s1 + j];
            j++;
            r++;
        }

        // 拷贝排序后的数组到对应的位置
        for (int u = 0;u<len;u++) {
            nums[b + u] = temp[u];
        }
    }
}
