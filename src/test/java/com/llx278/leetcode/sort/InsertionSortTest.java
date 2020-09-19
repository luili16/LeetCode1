package com.llx278.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortTest {

    private InsertionSort insertionSort = new InsertionSort();

    @Test
    public void test(){
        int[] nums = new int[] {5,2,4,6,1,3};

        Random random = new Random();


        insertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
