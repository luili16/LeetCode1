package com.llx278.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

public class SearchTest {

    private Search search = new BinarySearch();

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};

        int index = search.search(9,nums);
        Assert.assertEquals(8,index);
    }
}
