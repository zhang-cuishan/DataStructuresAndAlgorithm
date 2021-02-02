package com.springchang.datastructures.search;

import java.util.Arrays;
import java.util.Vector;

/**
 * 二分查找,数组必须为有序数组
 * @author : 张翠山
 */
public class BinarySearch {

//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4};
//        int index = binarySearch(arr, 0, arr.length-1, 5);
//        System.out.println("index = " + index);
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 33, 34, 34, 34, 44, 55};
        Vector<Integer> integers = binarySearchVector(arr, 0, arr.length-1, 56);
        System.out.println("integers = " + integers);
    }

    /**
     * 二分查找算法
     * @param arr 数组
     * @param left 左边坐标
     * @param right 右边坐标
     * @param toFindValue 要查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int toFindValue) {
        //确定边界和退出条件
        if (left > right) {
            return -1;
        }

        int mid = (right+left)/2;

        if(toFindValue < arr[mid]) {
            return binarySearch(arr, left, mid-1, toFindValue);
        } else if (toFindValue > arr[mid]) {
            return binarySearch(arr, mid+1, right, toFindValue);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找算法的变种：返回相等的值的下标结合
     * @param arr
     * @param left
     * @param right
     * @param toFindValue
     * @return
     */
    public static Vector<Integer> binarySearchVector(int[] arr, int left, int right, int toFindValue) {
        //确定边界和退出条件
        if (left > right) {
            return new Vector<Integer>();
        }

        int mid = (right+left)/2;

        if(toFindValue < arr[mid]) {
            return binarySearchVector(arr, left, mid-1, toFindValue);
        } else if (toFindValue > arr[mid]) {
            return binarySearchVector(arr, mid+1, right, toFindValue);
        } else {
            Vector<Integer> vector = new Vector<>();

            int index = mid;
            //向左边搜索，直到值不等于toFindValue为止
            while(index >= 0 && arr[index] == toFindValue) {
                vector.add(index);
                index--;
            }

            //向右边搜索，直到值不等于toFindValue为止
            index = mid+1;
            while(index <= arr.length-1 && arr[index] == toFindValue) {
                vector.add(index);
                index++;
            }

            return vector;
        }
    }
}
