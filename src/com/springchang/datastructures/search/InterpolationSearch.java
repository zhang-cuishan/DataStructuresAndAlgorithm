package com.springchang.datastructures.search;

/**
 * 插值查找算法,数组必须为有序数组
 * @author : 张翠山
 */
public class InterpolationSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4,10};
        int index = interpolatSearch(arr, 0, arr.length-1, 4);
        System.out.println("index = " + index);
    }

    /**
     * 插值查找算法
     * @param arr 数组
     * @param left 左边坐标
     * @param right 右边坐标
     * @param toFindValue 要查找的值
     * @return
     */
    public static int interpolatSearch(int[] arr, int left, int right, int toFindValue) {
        //确定边界和退出条件
        if (left >= right || toFindValue < arr[0] || toFindValue > arr[arr.length-1]) {
            return -1;
        }

        int mid = left+(right-left)*(toFindValue-arr[left])/(arr[right]-arr[left]);

        if(toFindValue < arr[mid]) {
            return interpolatSearch(arr, left, mid-1, toFindValue);
        } else if (toFindValue > arr[mid]) {
            return interpolatSearch(arr, mid+1, right, toFindValue);
        } else {
            return mid;
        }
    }
}
