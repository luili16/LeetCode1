package com.llx278.leetcode.medium;
import java.util.*;

public class SetZeros {

    public void setZeroes(int[][] matrix) {

        int xMax = matrix[0].length;
        int yMax = matrix.length;

        int xZ = -1;
        int yZ = -1;
        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                int m = matrix[i][j];
                if (m == 0) {
                    if (j == 0 && i == 0) {
                        xZ = 0;
                        yZ = 0;
                    }else if (i == 0) {
                        xZ = 0;
                    } else if (j == 0) {
                        yZ = 0;
                    } else {
                        // 判断m既不是在第一行上也不是在第一列上
                        // 因为m如果在第一行或者第一列上的话就不需要置零了
                        // 标志m所在的列为0
                        matrix[0][j] = 0;
                        // 标志m所在的行为0
                        matrix[i][0] = 0;
                    }
                }
            }
        }


        for (int[] xs:matrix) {
            //System.out.println(Arrays.toString(xs));
        }
        System.out.println("----------------------");
        // 标志结束，开始对第一行和第一列进行遍历
        int[] xCou = matrix[0];
        for (int i = 1; i < xCou.length; i++) {
            int m = xCou[i];
            if (m == 0) {
                for (int j = 1; j < yMax; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i <yMax; i++) {
            int m = matrix[i][0];
            if (m == 0) {
                // m所在的行为0
                for (int j = 0; j < xMax; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行和第一列
        // 第一行和第一列都为0;
        if (xZ == 0) {
            for (int i = 0; i < xCou.length; i++) {
                xCou[i] = 0;
            }
        }

        if (yZ == 0) {
            for (int i = 0; i < yMax; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

   //     int[][] m0 = {{1,1,1}};

//    int[][] m0 = {
//            {1},
//            {1},
//            {1}
//    };

//    int[][] m0 = {
//            {1},
//            {0},
//            {1}
//    };

       //int[][] m0 = {{1,0,1}};

//        int[][] m0 = {
//                {1,0,1},
//                {0,1,1},
//                {1,1,1},
//        };

//        int[][] m0 = {
//                {1,1,1},
//                {1,1,0},
//                {1,1,1}
//        };

//        int[][] m0 = {
//                {1,0,1},
//                {1,1,1},
//                {1,1,1}
//        };

//        int[][] m0 = {
//                {1,1,1},
//                {1,0,1},
//                {1,1,1}
//        };

        int[][] m0 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

//        int[][] m0 = {
//                {1,1,1,1},
//                {0,1,1,1},
//                {1,1,1,1},
//        };


       // [0,0], [0,1],[1,1],[2,1],[2,2],[3,1],[3,3],[4,2],[6,3],[100,2],[100,100]


        for (int[] xs : m0) {
            System.out.println(Arrays.toString(xs));
        }
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.isEmpty();
        System.out.println("--------------");
        new SetZeros().setZeroes(m0);
        for (int[] xs : m0) {
            System.out.println(Arrays.toString(xs));
        }
    }
}
