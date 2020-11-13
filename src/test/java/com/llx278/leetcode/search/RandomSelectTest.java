package com.llx278.leetcode.search;

import com.llx278.leetcode.sort.BubbleSort;
import com.llx278.leetcode.sort.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RandomSelectTest {

    @Test
    public void test() {
        // 0 1 4 5 6 7 8 9 10 11 22 23
        int[] nums = new int[]{8,5,6,9,10,1,4,7,22,23,0,11};
        int[] backs = new int[]{8,5,6,9,10,1,4,7,22,23,0,11};
        Sort sort = new BubbleSort();
        sort.sort(backs);
        System.out.println(Arrays.toString(backs));
        RandomizedSelect select = new RandomizedSelect();
        int ret = select.select(nums,0,nums.length - 1,4);
        System.out.println(Arrays.toString(nums));
        Assert.assertEquals(6,ret);
    }
}
