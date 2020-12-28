package com.springchang.datastructures.backtrack;

/**
 * @author : 张翠山
 * 8皇后问题，回溯求解
 */
public class EightQueens {

    //定义皇后数量
    private static final int N = 8;

    //定义棋盘
    private static int[][] chess = new int[N][N];

    public static void main(String[] args) {

        //开始放入第一个皇后
        putQueen(0);

        print(chess);
    }

    /**
     * 尝试放入第N个皇后
     * @param n
     * @return
     */
    public static boolean putQueen(int n) {

        //递归的出口，皇后是否放到了最后一个，如果已经放到了最后一个，则表示该方案可行
        if(n == N) {
            return true;
        }

        //遍历该行的所有单元格，查看当前的皇后是否合法，如果合法则继续放入下一个皇后，如果不合法，则继续下一个位置，如果都不合法，则回退到上一个皇后的位置放入
        for (int i = 0; i < N; i++) {

            //先给当前行的所有单元格清零,避免数据的污染
            for (int j = 0; j < N; j++) {
                //所有的数据都是位于第n行，第j列的数据
                chess[n][j] = 0;
            }

            //判断当前的单元格是否合法
            if(check(n, i)) {
                chess[n][i] = n+1;

                //检查到放入的这个皇后是合法的，则继续放入下一个皇后
                boolean result = putQueen(n+1);
                //判断下一个要放入的皇后是否合法，如果下一个皇后也合法，则返回
                if(result) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 检测这个棋盘的当前皇后是否合法
     * @param i
     * @param j
     * @return
     */
    public static boolean check(int i, int j) {

        //判断该行是否已经有数据
        for (int k = 0; k < N; k++) {
            if(chess[i][k] != 0) {
                return false;
            }
        }

        //判断该列是否已经有数据
        for (int k = 0; k < N; k++) {
            if(chess[k][j] != 0) {
                return false;
            }
        }

        //判断两个皇后是否在同一斜线上
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l < N; l++) {
                if(chess[k][l] != 0 && Math.abs(i-k) == Math.abs(j-l)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void print(int[][] matrix) {
        for (final int[] arr: matrix) {
            for (final int data: arr) {
                System.out.printf("%d ",data);
            }
            System.out.println();
        }
    }
}
