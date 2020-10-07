package com.llx278.leetcode.search;

import com.llx278.leetcode.sort.BubbleSort;
import com.llx278.leetcode.sort.Sort;

// 二进制搜索（非递归版本）
public class BinarySearch implements Search {
    @Override
    public int search(int value, int[] nums) {

        // 保证有序
        Sort sort = new BubbleSort();
        sort.sort(nums);

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == value) {
                return mid;
            }

            if (nums[mid] > value) { // 左边
                high = mid - 1;
            }

            if (nums[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
