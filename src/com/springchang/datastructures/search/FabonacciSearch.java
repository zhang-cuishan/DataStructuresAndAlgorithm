package com.springchang.datastructures.search;

import java.util.Arrays;

/**
 * 斐波那契搜索,前提是数组有序
 * @author : 张翠山
 */
public class FabonacciSearch {

    static final int MAX_SIZE = 20;

    //获取斐波那契数列前20个数据
    private static int[] fabonacci() {
        int[] arr = new int[MAX_SIZE];

        arr[0] = arr[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr;
    }

    /**
     * 斐波那契搜索算法
     * @param arr
     * @param key
     * @return
     */
    public static int fabonacciSearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length-1;

        //1.获取斐波那契数列
        int[] fabArr = fabonacci();

        //2.计算k的位置
        int k = 0;
        while(fabArr[k] < high) {
            k++;
        }

        //创建新数组，并补齐fabArr[k]个元素
        int[] temp = Arrays.copyOf(arr, fabArr[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while(low <= high) {
            int mid = low + fabArr[k-1]-1;
            if(temp[mid] > key) {
                high = mid-1;
                k--;
            } else if(temp[mid] < key) {
                low = mid+1;
                k -= 2;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {10, 12, 13, 14, 15, 17, 18};

        int key = 16;

        int index = fabonacciSearch(arr, key);
        System.out.printf("元素 %d 的小标值为 %d\n", key, index);
    }
}
