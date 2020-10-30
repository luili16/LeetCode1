package com.llx278.leetcode.sort;

public class CountingSort {


    public void sort(int[] nums,int k) {
        if (nums.length == 0) {
            return;
        }
        int[] out = new int[nums.length];
        countingSort(nums,out,k);
        System.arraycopy(out, 0, nums, 0, nums.length);
    }

    // k是nums里面的最大值
    private void countingSort(int[] A,int[] B,int k) {
        // 包含0
        int[] C = new int[k + 1];
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }
        // C[i] now contains the number of elements equal to i
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        // C[i] now contains the number of elements less than or equal to i
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int j = A.length - 1; j >=0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }

}
