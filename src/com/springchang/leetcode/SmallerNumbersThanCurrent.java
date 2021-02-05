package com.springchang.leetcode;

import java.util.Arrays;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * @author : 张翠山
 */
public class SmallerNumbersThanCurrent {

    /**
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(nums[j] < nums[i] && j != i) {
                    count++;
                }
            }
            arr[i] = count;
        }

        return arr;
    }

    public static void main(String[] args) {
        SmallerNumbersThanCurrent demo = new SmallerNumbersThanCurrent();
        int[] arr = new int[]{8,1,2,2,3};
        int[] result = demo.smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.stream(result).toArray());
    }
}
