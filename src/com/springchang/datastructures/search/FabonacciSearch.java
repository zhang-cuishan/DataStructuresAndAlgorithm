package com.springchang.datastructures.search;

import java.util.Arrays;

/**
 * 斐波那契搜索,前提是数组有序
 * @author : 张翠山
 */
public class FabonacciSearch {

    static final int MAX_SIZE = 20;

    //获取斐波那契数列前20个数据
    public static int[] fabonacci() {
        int[] arr = new int[MAX_SIZE];

        arr[0] = arr[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {10, 12, 13, 14, 15, 17, 18};

        int key = 17;

        //斐波那契数列
        int[] fabonacciArray = fabonacci();

        int low = 0;

        //最后一个元素的下标
        int high = arr.length-1;

        int k = 0;

        while(fabonacciArray[k]-1 <= high) {
            k++;
        }

        //用一个新的数组来保持数据
        int lenth = fabonacciArray[k+1]-1;
        int[] temp = Arrays.copyOf(arr,lenth);
        for (int i = high; i < temp.length; i++) {
            temp[i] = temp[high];
        }

        //计算黄金分割点的下标
        int mid = low + fabonacciArray[k-1]-1;

        while(low < mid) {
            if(temp[mid] > key) {
                high = mid-1;
                k -= 1;
            } else if(temp[mid] < key) {
                low = low+1;
                k -= 2;
            } else {
                System.out.println("找到下标:"+mid);
                return;
            }
            mid = low + fabonacciArray[k-1]-1;
        }
        System.out.println("没有找到数据"+key);
    }
}
