package com.llx278.leetcode.medium;

import java.util.Arrays;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length; // y
        int n = obstacleGrid[0].length; // x

        if (m == 1) {
            for (int[] i : obstacleGrid) {
                for (int j : i) {
                    if (j == 1) {
                        return 0;
                    }
                }
            }
            return 1;
        }

        if (n == 1) {
            for (int[] i : obstacleGrid) {
                if (i[0] == 1) {
                    return 0;
                }
            }
            return 1;
        }


        for (int[] ns:obstacleGrid) {
            for (int i = 0; i < ns.length; i++) {
                int o = ns[i];
                if (o == 0) {
                    ns[i] = -1;
                }
                if (o == 1) {
                    ns[i] = 0;
                }
            }
        }
        obstacleGrid[0][0] = 0;
        printArray(obstacleGrid);
        nextPath(m,n,0,0,obstacleGrid);
        printArray(obstacleGrid);
        return obstacleGrid[0][0];
    }

    private void printArray(int[][] result) {
        System.out.println("-----");
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----");
    }
                             // y  // x
    private void nextPath(int m,int n, int m0,int n0,int[][] result) {

        if (m0 == m - 1 && n0 == n - 1) {
            return;
        }

        if (n0 == n - 1 && m0 != m - 1) {
            // 走到了最右边
            if (result[m0 + 1][n0] == 0) {
                result[m0][n0] = 0;
            } else {
                result[m0][n0] = 1;
            }
        }

        if (m0 == m - 1 && n0 != n - 1) {
            // 走到了最下边
            if (result[m0][n0 + 1] == 0) {
                result[m0][n0] = 0;
            } else {
                result[m0][n0] = 1;
            }
        }


        if (n0 < n - 1 && result[m0][n0 + 1] == -1) {
            nextPath(m,n,m0,n0 + 1,result);
        }

        if (m0 < m - 1 && result[m0 + 1][n0] == -1) {
            nextPath(m,n,m0+1,n0,result);
        }

        if (m0 < m - 1 && n0 < n - 1) {
            result[m0][n0] = result[m0 + 1][n0] + result[m0][n0 + 1];
        }
    }

    public static void main(String[] args) {
        int[][] val = new int[][] {
                {1,0},
                {0,0},
        };

        int[][] val2 = new int[][] {
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,1,0,0}
        };


        int count = new UniquePaths2().uniquePathsWithObstacles(val);
        System.out.println("count = " + count);
    }
}
