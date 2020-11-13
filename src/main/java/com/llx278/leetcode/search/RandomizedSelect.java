package com.llx278.leetcode.search;

import java.util.Random;

public class RandomizedSelect {

    // 返回数组中第i小的元素
    public int select(int[] nums,int p,int r,int i) {

        if (p == r) {
            return nums[p];
        }

        // q是主元
        int q = randomPartition(nums,p,r);
        // 主元在数组中的位置
        int k = q - p;
        if (i == k) {
            return nums[q];
        } else if (i < k) {
            // 左边
            return select(nums,p,q - 1,i);
        } else {
            // i > k
            return select(nums,q + 1,r,i - (k + 1));
        }
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

}
