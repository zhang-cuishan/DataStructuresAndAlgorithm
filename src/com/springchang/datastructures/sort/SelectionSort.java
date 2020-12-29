package com.springchang.datastructures.sort;

/**
 * 选择排序
 * @author : 张翠山
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {

        //index标记正在标记的位置
        for (int index = 0; index < arr.length; index++) {

            //一趟查询，查找最小值的下标index和最小值value
            int minIndex = index;
            int minValue = arr[index];
            for (int i = index+1; i < arr.length; i++) {
                if(arr[i] < minValue) {
                    minIndex = i;
                    minValue = arr[i];
                }
            }

            //交换一下最小值和当前index值
            if(index != minIndex) {
                arr[minIndex] = arr[index];
                arr[index] = minValue;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 5, 7, 2, 3};

        System.out.println("排序前数组：");
        ArrayUtils.print(arr);

        selectionSort(arr);

        System.out.println("排序后数组:");
        ArrayUtils.print(arr);
    }
}
