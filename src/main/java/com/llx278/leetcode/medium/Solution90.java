package com.llx278.leetcode.medium;

import java.util.*;
import java.util.function.Consumer;


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

    private final List<List<Integer>> results = new ArrayList<>();
    private final Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        results.add(new ArrayList<>());
        subSetsWithDup(nums,nums.length-1);
        return results;
    }

    private void subSetsWithDup(int[] nums,int p) {
        if (p < 0) {
            return;
        }
        for (int i = p;i>=0;i--) {
            stack.push(nums[i]);
            subSetsWithDup(nums,i - 1);
            boolean same = false;
            List<Integer> c = new ArrayList<>(stack);
            Collections.sort(c);
            for (List<Integer> l : results) {
                if (l.size() == c.size()) {
                    List<Integer> d = new ArrayList<>(l);
                    Collections.sort(d);
                    boolean arrayEqual = true;
                    for (int j = 0; j < c.size(); j++) {
                        if (!d.get(j).equals(c.get(j))) {
                            arrayEqual = false;
                            break;
                        }
                    }
                    if (arrayEqual) {
                        same = true;
                    }
                }
            }
            if (!same) {
                results.add(new ArrayList<>(stack));
            }

            stack.pop();
        }
    }
}
