package com.springchang.datastructures.backtrack;

import java.util.Stack;

/**
 * 走迷宫
 * @author : 张翠山
 */
public class MiGong {

    private static final int N = 8;

    static Stack<Point> stepStack = new Stack<Point>();

    public static void main(String[] args) {
        //生成一个8x8迷宫
        int[][] map =new int[N][N];

        //给左右两边添加墙的效果
        for (int i = 0; i < N; i++) {
            map[i][0] = 1;//给第一列元素赋值
            map[i][N-1] = 1;//给最后一列赋值
        }

        //给上下两边添加墙的效果
        for (int i = 0; i < N; i++) {
            map[0][i] = 1;//给第一列元素赋值
            map[N-1][i] = 1;//给最后一列赋值
        }

        //给中间加上墙的效果
        map[3][1] = 1;
        map[3][2] = 1;
        map[5][3] = 1;

        //开始探测
        explore1(map, 1, 1);

        print(map);

        System.out.println("走出迷宫的步骤:");
        while(!stepStack.isEmpty()) {
            System.out.println(stepStack.pop());
        }
    }

    /**
     * 探测这一单元格是否能够走得通,走得通的意思是：这一单元格的状态是0，且能向四个方向的某一方向继续走完
     * 探路方向：↓←↑→
     * 1:墙面
     * 2：可以走,已经走过，但是不能走两次
     * 3：走过，不可行，
     * @return
     */
    private static boolean explore(int[][] map, int i, int j) {

        //递归的出口,就是走到最后一个节点
        if(map[N-2][N-2] == 2) {
            return true;
        } else {

            //探测这一步单元格是否是有效单元格
            if (map[i][j] == 0) {
                //探测这一步，先假定这一步是可行的
                map[i][j] = 2;

                //如果是有效单元格，则继续探测下一步是否继续有效
                if (explore(map, i + 1, j)) {//往下探测
                    return true;
                } else if (explore(map, i, j - 1)) {//往左边探测
                    return true;
                } else if (explore(map, i - 1, j)) {//往上探测
                    return true;
                } else if (explore(map, i, j + 1)) { //往右边探测
                    return true;
                } else {//4个方向都探测不到，则说明是条死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //不是有效单元格，则返回false
                return false;
            }
        }
    }

    /**
     * 算法和上面一致，只是修改探测策略：下，右，上，左
     * @param map
     * @param i
     * @param j
     * @return
     */
    private static boolean explore1(int[][] map, int i, int j) {

        //递归的出口,就是走到最后一个节点
        if(map[N-2][N-2] == 2) {
            return true;
        } else {

            //探测这一步单元格是否是有效单元格
            if (map[i][j] == 0) {
                //探测这一步，先假定这一步是可行的
                map[i][j] = 2;

                if (explore1(map, i+1, j)) {
                    stepStack.push(new Point(i, j));
                    return true;
                } else if (explore1(map, i, j+1)) {
                    stepStack.push(new Point(i, j));
                    return true;
                } else if (explore1(map, i-1, j)) {
                    System.out.printf("(%d,%d)\n", i, j);
                    return true;
                } else if (explore1(map, i, j-1)) {
                    stepStack.push(new Point(i, j));
                    return true;
                } else {//4个方向都探测不到，则说明是条死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //不是有效单元格，则返回false
                return false;
            }
        }
    }

    private static void print(int[][] matrix) {
        for (final int[] arr: matrix) {
            for (final int data: arr) {
                System.out.printf(" %d\t",data);
            }
            System.out.println();
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }
}
