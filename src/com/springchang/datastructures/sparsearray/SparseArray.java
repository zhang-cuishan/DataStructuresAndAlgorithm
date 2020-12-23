package com.springchang.datastructures.sparsearray;

/**
 * @author : 张翠山
 * @Descption: 稀疏数组的使用案例
 * @date 2020/12/23
 */
public class SparseArray {

    public static void main(String[] args) {

        //原始稀疏数组
        int[][] chessArr = new int[11][11];
        //给稀疏数组赋值,1代表黑子，2代表白子
        chessArr[1][2] = 1;
        chessArr[2][3] = 1;
        chessArr[4][5] = 2;
        chessArr[10][10] = 2;

        //打印原始数组
        System.out.println("原始数组:");
        printArray(chessArr);

        //遍历原始数组，计算稀疏数组需要的第一行数据
        int m = chessArr.length;//原始数组的行数
        int n = chessArr[0].length;//原始数组的列数
        int sum = 0;//原始数组的有效记录数
        for (int arr[]: chessArr) {
            for (int data: arr) {
                if(data != 0) {
                    sum++;
                }
            }
        }

        //定义一个稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = m;
        sparseArr[0][1] = n;
        sparseArr[0][2] = sum;
        //定义一个稀疏数组的指针
        int index = 0;
        //稀疏数组转换算法，遍历原始数组，给稀疏数据赋值
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if(chessArr[i][j] != 0) {
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = chessArr[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组");
        printArray(sparseArr);

        //从稀疏数组还原回原始的数组
        int[][] chessArr1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //打印还原后的数组
        System.out.println("还原后的数组");
        printArray(chessArr1);
    }

    //打印数组
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}
