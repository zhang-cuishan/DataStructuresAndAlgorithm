package com.springchang.datastructures.tree;

/**
 * @author : 张翠山
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {

        ArrayBinaryTree tree = new ArrayBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});

        System.out.println("先序遍历:");
        tree.preTravle(0);

        System.out.println("中序遍历:");
        tree.midTravle(0);
    }
}
