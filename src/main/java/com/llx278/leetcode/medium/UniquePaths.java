package com.llx278.leetcode.medium;

import java.math.BigInteger;
import java.util.Arrays;

public class UniquePaths {
    public BigInteger uniquePaths(int m, int n) {
        BigInteger[][] res = new BigInteger[m][n];
        for (BigInteger[] re : res) {
            for (int i = 0; i < re.length; i++) {
                re[i] = new BigInteger("0");
            }
        }
        nextPath(m,n,0,0,res);
        printArray(res);
        return res[0][0];
    }

    private void printArray(BigInteger[][] result) {
        System.out.println("-----");
        for (BigInteger[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----");
    }

    private void nextPath(int m,int n, int x,int y,BigInteger[][] result) {
        //System.out.println("x="+x+"y="+y);
        if (x == m - 1 && y == n - 1) {

            return;
        }

        if (x == m - 1 || y == n - 1) {
            result[x][y] = new BigInteger("1");
        }

        if (x < m - 1 && result[x + 1][y].equals(new BigInteger("0"))) {
            x++;
            nextPath(m,n,x,y,result);
            x--;
        }

        if (y < n - 1 && result[x][y + 1].equals(new BigInteger("0"))) {
            y++;
            nextPath(m,n,x,y,result);
            y--;
        }

        if (y < n -1 && x < m - 1) {
            result[x][y] = result[x+1][y].add(result[x][y + 1]);
        }

        //printArray(result);
    }

    /**
     * [[0,1]]
     * [[0]]
     * [[1,1]]
     * [[1],[1]]
     * [[0],[0],[0]]
     * @param args
     */
    public static void main(String[] args) {
        BigInteger ret = new UniquePaths().uniquePaths(50,50);
        System.out.println(ret);
    }
}
