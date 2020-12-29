package com.springchang.datastructures.sort;

/**
 * 下沉排序，就是传说中的冒泡排序
 * @author : 张翠山
 */
public class SinkSort {

    public static void sinkSort(int[] arr) {
        
        //遍历数据，相邻俩数两两对比
        for (int i = arr.length - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    //交换俩数
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 4, 5, 7, 2, 3};

        System.out.println("排序前数组：");
        ArrayUtils.print(arr);

        sinkSort(arr);

        System.out.println("排序后数组:");
        ArrayUtils.print(arr);
    }
}
