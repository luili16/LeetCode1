package com.llx278.leetcode.medium;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return nums[0] == target;
        }

        // 判断target在那个段里面
        int middle = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                middle = i;
                break;
            }
        }

        System.out.println("left:"+ Arrays.toString(Arrays.copyOfRange(nums,0,middle)));
        System.out.println("right:"+Arrays.toString(Arrays.copyOfRange(nums,middle,nums.length)));

        // 判断落在哪个边界上面

        if (target == nums[0]) {
            return true;
        }
        if (middle != 0 && target ==  nums[middle - 1]) {
            return true;
        }

        if (target == nums[middle]) {
            return true;
        }

        if (target == nums[nums.length - 1]) {
            return true;
        }

        if (middle != 0 && (target >= nums[0] || target <= nums[middle - 1])) {
            int index = Arrays.binarySearch(nums,0,middle,target);
            if (index > 0) {
                return true;
            }
        }

        if (target >= nums[middle] || target <= nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums,middle,nums.length,target);
            return index > 0;
        }

        return false;
    }
}
