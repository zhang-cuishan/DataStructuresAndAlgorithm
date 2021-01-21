package com.springchang.datastructures.gernaration;

/**
 * @author : 张翠山
 */
public class GenericMax {

    public static <E extends Comparable> E max(E[] arr) {
        E maxValue = arr[0];
        for (E i : arr) {
            if(i.compareTo(maxValue) > 0) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Double[] arr = new Double[5];
        arr[0] = 1.0;
        arr[1] = 2.2;
        arr[2] = 3.2;
        arr[3] = 2.2;
        arr[4] = 5.0;

        System.out.println(max(arr));
    }
}
