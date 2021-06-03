package com.springchang.datastructures.tree.binarytree;

import java.util.List;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(new String[]{"1", "3", "6", "5", "2", "7", "9", "8", "0", "4"});

        System.out.println("节点数 = " + binarySearchTree.getSize());

        System.out.println("中序遍历：");
        binarySearchTree.inorder();

        System.out.println("\n先序遍历:");
        binarySearchTree.preorder();

        System.out.println("\n后续遍历:");
        binarySearchTree.postorder();

        System.out.println("\n存在数据 1 ? " + binarySearchTree.search("10"));

        List<BinarySearchTree.TreeNode> list = binarySearchTree.path("10");
        System.out.println("8的路径 = ");
        for (BinarySearchTree.TreeNode treeNode : list) {
            System.out.println("treeNode.element = " + treeNode.element);
        }

        binarySearchTree.clear();

        System.out.println("清空后长度 = "+binarySearchTree.getSize());
        System.out.println("清空后后续遍历:");
        binarySearchTree.postorder();
    }
}
