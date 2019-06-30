package com.llx278.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        sort(intervals);
        List<int[]> result = new LinkedList<>();
        recurseMerge(intervals,0,result);
        int[][] ret = new int[result.size()][2];
        for (int i = 0; i < result.size();i++) {
            ret[i] = result.get(i);
        }
        return ret;

    }

    public void recurseMerge(int[][] intervals, int index, List<int[]> result) {
        if (index == intervals.length) {
            return;
        }
        if (index == intervals.length - 1) {
            result.add(intervals[index]);
            return;
        }
        int[] begin = intervals[index];
        int nextIndex= index + 1;
        while (nextIndex != intervals.length) {
            int[] next = intervals[nextIndex];
            int[] temp = mergeOnce(begin,next);
            if (temp == null) {
                break;
            } else {
                begin = temp;
            }
            nextIndex++;
        }
        result.add(begin);
        recurseMerge(intervals,nextIndex,result);
    }

    public void sort(int[][] intervals) {

        for (int j = 1;j < intervals.length; j++) {
            int[] key = intervals[j];
            int i = j - 1;
            while (i >= 0 && intervals[i][0] > key[0]) {
                intervals[i + 1] = intervals[i];
                i--;
            }
            intervals[i + 1] = key;
        }
    }

    public int[] mergeOnce(int[] i0,int[] i1) {
        int a = i0[0];
        int b = i0[1];
        int c = i1[0];
        int d = i1[1];
        int d0 = Math.abs(b - a);
        int e0 = Math.abs(d - c);
        int[] res = new int[2];
        boolean succ = false;
        if (d0 > e0) {

            if (b == c ||
                    a < c && c < b && d > b ) {
                res[0] = a;
                res[1] = d;
                succ = true;
            } else if (d == b ||
                            a < c && d < b ||
                            a == c) {
                res[0] = a;
                res[1] = b;
                succ = true;
            } else if (a > c && a < d ||
                    a == d) {
                res[0] = c;
                res[1] = b;
                succ = true;
            }
        } else if (d0 < e0) {
            if (b == c ||
                    a<c&&c<b&&b<d ||
                    a == c
            ) {
                res[0] = a;
                res[1] = d;
                succ = true;
            } else if (a > c && b < d||
                    a>c && b == d) {
                res[0] = c;
                res[1] = d;
                succ = true;
            } else if (a > c && d < b||
                    a > c && a == d) {
                res[0] = c;
                res[1] = b;
                succ = true;
            }
        } else { // d0 == e0
            if (b == c||
                    a < c && c < b) {
                res[0] = a;
                res[1] = d;
                succ = true;
            } else if(b == d) {
                res[0] = a;
                res[1] = b;
                succ = true;
            } else if (a > c && a < d || a== d) {
                res[0] = c;
                res[1] = b;
                succ = true;
            }

        }
        if (succ) {
            return res;
        }
        return null;
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        // [[1,3],[2,6],[8,10],[15,18]]
        int[][] ints = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] ints1 = {
                {1,4},
                {4,5}
        };
        int[][] ints2 = {
                {1,3},
                {8,10},
                {15,18},
                {2,6}
        };
        int[][] ints3 = {{4,5},{1,4},{0,1}};
        int[][] ints4 = {{0,1},{1,4},{4,5}};

        int[][] ret = m.merge(ints4);

        for (int[] is : ret) {
            System.out.println(Arrays.toString(is));
        }


        System.out.println("-------");

        m.sort(ints3);
        for (int[] is : ints3) {
            System.out.println(Arrays.toString(is));
        }


        int[] i0 = {1,6};
        int[] i1 = {8,10};
        //int[] ret = m.mergeOnce(i0,i1);
        //System.out.println(Arrays.toString(ret));
    }
}
