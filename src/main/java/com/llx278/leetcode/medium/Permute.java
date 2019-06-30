package com.llx278.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length == 0) {
            List<Integer> result = copyFrom(nums);
            results.add(result);
            return results;
        }

        if (nums.length == 1) {
            List<Integer> result = copyFrom(nums);
            results.add(result);
            return results;
        }

        subPermute(nums,0,nums.length,results);
        return results;
    }

    private void subPermute(int[] nums,int begin,int end,List<List<Integer>> results) {
        if (begin == end) {
            List<Integer> result = copyFrom(nums);
            results.add(result);
            return;
        }

        for (int i = begin; i < end; i++) {
            swap(nums,i,begin);
            subPermute(nums,begin+1,end,results);
            swap(nums,i,begin);
        }
    }

    private List<Integer> copyFrom(int[] nums) {
        List<Integer> result= new ArrayList<>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Permute p= new Permute();
        List<List<Integer>> permute = p.permute(a);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
        /**
         * x = 0 y = 0
         * x = 1 y = 0
         * x = 2 y = 0
         * x = 3 y = 0
         * x = 4 y = 0
         * x = 5 y = 0
         * x = 6 y = 0
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 5 y = 1
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 6 y = 2
         * x = 4 y = 1
         * x = 5 y = 1
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 6 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 3 y = 1
         * x = 4 y = 1
         * x = 5 y = 1
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 6 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 4 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 2 y = 1
         * x = 3 y = 1
         * x = 4 y = 1
         * x = 5 y = 1
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 6 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 4 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 3 y = 2
         * x = 4 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 1 y = 1
         * x = 2 y = 1
         * x = 3 y = 1
         * x = 4 y = 1
         * x = 5 y = 1
         * x = 6 y = 1
         * x = 6 y = 2
         * x = 6 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 4 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 3 y = 2
         * x = 4 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         * x = 2 y = 2
         * x = 3 y = 2
         * x = 4 y = 2
         * x = 5 y = 2
         * x = 6 y = 2
         */
    }
}
