package com.llx278.leetcode.sort;

// 堆排序
public class HeapSort {

    public void sort(int[] nums) {
        buildMaxHeap(nums);
        int len = nums.length;
        for (int i = nums.length - 1; i>0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            len--;
            maxHeapify(nums,len,0);
        }
    }

    private int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    private int left(int i) {
        return (i + 1) * 2 - 1;
    }

    private int right(int i) {
        return ((i + 1) * 2 + 1) - 1;
    }

    private void buildMaxHeap(int[] nums) {
        int heapSize = nums.length - 1;
        for (int i = heapSize/2; i>=0; i--) {
            maxHeapify(nums, nums.length,i);
        }
    }

    private void maxHeapify(int[] nums, int len ,int i) {

        int l = left(i);
        int r = right(i);
        Integer largest;
        if (l < len && nums[l] > nums[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < len && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            maxHeapify(nums,len,largest);
        }
    }
}
