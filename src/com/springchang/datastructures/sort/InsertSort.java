package com.springchang.datastructures.sort;

/**
 * 插入排序
 * @author : 张翠山
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        int insertVal = 0;  //待插入的数据
        int insertIndex = 0;//待插入的元素下标

        for(int i = 1; i < arr.length; i++) {
            insertIndex = i-1;
            insertVal = arr[i];

            while (insertIndex >= 0 && arr[insertIndex] >= insertVal) {
                //数据后移
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            //判断是否需要移动，如果前一个数等于后一个数则不需要移动
            if(insertIndex+1 != i) {
                arr[insertIndex+1] = insertVal;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 4, 5, 7, 2, 3};

        System.out.println("排序前数组：");
        ArrayUtils.print(arr);

        insertSort(arr);

        System.out.println("排序后数组:");
        ArrayUtils.print(arr);
    }
}
