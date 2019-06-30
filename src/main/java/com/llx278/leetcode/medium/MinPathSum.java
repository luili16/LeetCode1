package com.llx278.leetcode.medium;

import java.util.Arrays;

public class MinPathSum {
    class Holder {
        int min = 0;
        int temp = 0;
    }

    public int minPathSum(int[][] grid) {

        int maxX = grid[0].length - 1;
        int maxY = grid.length - 1;
        System.out.println("maxX="+maxX+" maxY="+maxY);
        for (int j = maxY; j >= 0; j--) {
            for (int i = maxX; i >= 0; i--) {

                if (j == maxY && i == maxX) {
                    continue;
                } else if (i != maxX && j == maxY) { // 最后一行
                    grid[j][i] += grid[j][i + 1];
                } else if (j != maxY && i == maxX) { // 最后一列
                    grid[j][i] += grid[j + 1][i];
                } else {
                    int n = grid[j][i];
                    int d = grid[j + 1][i];
                    int r = grid[j][i + 1];

                    // 都不是，那么就判断向右和向左那个小
                    if (r > d) {
                        grid[j][i] +=d;
                    } else {
                        grid[j][i] += r;
                    }
                }
            }
        }

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int[][] r = new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int ret = new MinPathSum().minPathSum(r);
        System.out.println("answer is " + ret);
    }
}
