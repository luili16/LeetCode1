package com.llx278.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        stack.add(nums[0]);
        return new ArrayList<>();
    }
}
