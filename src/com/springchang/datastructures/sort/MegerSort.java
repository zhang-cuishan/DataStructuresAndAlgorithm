package com.springchang.datastructures.sort;

/**
 * 归并排序
 * @author : 张翠山
 */
public class MegerSort {

    //分治算法，先分再治理
    public static void megerSort(int[] arr) {

        if(arr.length > 1) {
            //左半边数组
            int[] leftArr = new int[arr.length/2];
            //将arr原数组中的数据复制到左半边的数组中
            System.arraycopy(arr, 0, leftArr,0,leftArr.length);

            //右半边数组
            int[] rightArr = new int[arr.length-arr.length/2];
            //将arr原数组的数据复制到右半边的数组中去
            System.arraycopy(arr, arr.length/2, rightArr, 0, rightArr.length);

            //先分
            megerSort(leftArr);
            megerSort(rightArr);

            //再合
            int[] megerArr = meger(leftArr, rightArr);

            //将合并好的数组赋值给arr指针指向的地址，提供给上一层递归函数的调用
            System.arraycopy(megerArr, 0, arr, 0, megerArr.length);
        }
    }

    //合并俩已经排好序的数组,合并成一个新的数组
    private static int[] meger(int[] leftArr, int[] rightArr) {
        int[] megerArr = new int[leftArr.length+rightArr.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int megerIndex = 0;

        //移动俩指针，找出俩数组中较小的那个，放入合并的数组里面
        while(leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if(leftArr[leftIndex] <= rightArr[rightIndex]) {
                megerArr[megerIndex++] = leftArr[leftIndex++];
            } else {
                megerArr[megerIndex++] = rightArr[rightIndex++];
            }
        }

        //判断leftArr数组是否已经被扫描完毕
        while(leftIndex < leftArr.length) {
            megerArr[megerIndex++] = leftArr[leftIndex++];
        }

        //判断rightArr数组是否已经被扫描完毕
        while(rightIndex < rightArr.length) {
            megerArr[megerIndex++] = rightArr[rightIndex++];
        }

        return megerArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        megerSort(arr);

        ArrayUtils.print(arr);
    }
}
