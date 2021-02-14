package com.springchang.datastructures.tree;

/**
 * 顺序存储二叉树，前提是这棵树是完全二叉树
 * @author : 张翠山
 */
public class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree() {}

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 先序遍历
     */
    public void preTravle(int index) {
        if(arr == null || arr.length == 0) {
            throw new RuntimeException("数组为空，无法遍历");
        }
        System.out.println(arr[index]);

        if((index*2+1) < arr.length) {
            preTravle((index*2)+1);
        }

        if((index*2+2) < arr.length) {
            preTravle((index*2)+2);
        }
    }

    /**
     * 中序遍历
     */
    public void midTravle(int index) {
        if(arr == null || arr.length == 0) {
            throw new RuntimeException("数组为空，无法遍历");
        }

        if((index*2+1) < arr.length) {
            midTravle((index*2)+1);
        }
        System.out.println(arr[index]);
        if((index*2+2) < arr.length) {
            midTravle((index*2)+2);
        }
    }
}
