package com.llx278.leetcode.medium;

import java.util.*;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *      [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution78 {

    private final List<List<Integer>> results = new ArrayList<>();
    private final Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> subSets(int[] nums) {
        System.out.println(stack.toString());
        subSets(nums,nums.length-1);
        return results;
    }

    private void subSets(int[] nums, int p) {
        if (p < 0) {
            return;
        }
        for (int i = p; i >= 0; i--) {
            stack.push(nums[i]);
            subSets(nums,i-1);
            System.out.println(stack.toString());
            results.add(new ArrayList<>(stack));
            stack.pop();
        }
    }
}
