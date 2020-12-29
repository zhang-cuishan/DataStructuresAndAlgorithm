package com.springchang.datastructures.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序，排序的数据一般不大
 * @author : 张翠山
 */
public class BucketSort {

    //桶排序
    public static void bucketSort(int[] arr) {
    
        //找出待排序数组中有最大值是多少
        int maxVal = arr[0];
        for (int i : arr) {
            if(maxVal < i) {
                maxVal = i;
            }
        }

        //创建一个大小为maxVal+1的桶
        List[] buckets = new List[maxVal+1];

        //遍历原数组，向桶里面追加数据
        for (int i : arr) {
            if(buckets[i] == null) {
                buckets[i] = new ArrayList<Integer>();
            }
            buckets[i].add(i);
        }
        
        //从桶中取出数据
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null) {
                List list = buckets[i];
                for (Object o : list) {
                    arr[index++] = (Integer) o;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 2, 5, 6, 1, 3, 14, 12};
        bucketSort(arr);

        ArrayUtils.print(arr);
    }
}
