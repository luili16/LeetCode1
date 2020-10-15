package com.llx278.leetcode.ita;

public class MaximumSubArray {
    public int maximumSubArray(int[] nums) {
        Holder h = findMaximumSubArray(nums,0,nums.length - 1);
        return h.sum;
    }

    private class Holder {
        int maxLeft;
        int maxRight;
        int sum;
    }

    private Holder findMaximumSubArray(int[] nums,int low, int high) {

        if (low == high) {
            Holder h = new Holder();
            h.maxLeft = low;
            h.maxRight = high;
            h.sum = nums[low];
            return h;
        }

        int mid = low + high / 2;
        Holder left = findMaximumSubArray(nums,low,mid);
        Holder right = findMaximumSubArray(nums,mid + 1,high);
        Holder cross = findMaxCrossingSubArray(nums,low,mid,high);
        if (left.sum >= right.sum && left.sum >= cross.sum) {
            return left;
        } else if (right.sum >= left.sum && right.sum >= cross.sum) {
            return right;
        } else {
            return cross;
        }
    }

    private Holder findMaxCrossingSubArray(int[] nums,int low, int mid, int high) {

        int leftSum = Integer.MIN_VALUE;
        int maxLeft = -1;
        int sum = 0;
        for (int i = low; i <= mid;i++) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int maxRight = -1;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        if (maxLeft == -1 || maxRight == -1) {
            throw new RuntimeException("maxLeft == -1 or maxRight == -1 maxLeft:" + maxLeft + " maxRight:" + maxRight);
        }

        Holder h = new Holder();
        h.maxLeft = maxLeft;
        h.maxRight = maxRight;
        h.sum = leftSum + rightSum;
        return h;
    }
}
