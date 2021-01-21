package com.springchang.datastructures.gernaration;

/**
 * @author : 张翠山
 */
public class BubleSort {

    public static <E extends Comparable> void bubleSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++){
                if(arr[i].compareTo(arr[j]) > 0) {
                    E temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 1, 1, 2, 3, 4,2};
        bubleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
