package com.springchang.datastructures.tree;

/**
 * 二叉树
 * @author : 张翠山
 */
public class BinaryTree {

    //前序遍历
    public void preTravel(Node root) {
        System.out.println("root = " + root);

        if (root.getLeft() != null) {
            preTravel(root.getLeft());
        }
        if(root.getRight() != null) {
            preTravel(root.getRight());
        }
    }

    //中序遍历
    public void midTravel(Node root) {

        if (root.getLeft() != null) {
            midTravel(root.getLeft());
        }
        System.out.println("root = " + root);
        if(root.getRight() != null) {
            midTravel(root.getRight());
        }
    }

    //后序遍历
    public void afterTravel(Node root) {

        if (root.getLeft() != null) {
            afterTravel(root.getLeft());
        }

        if(root.getRight() != null) {
            afterTravel(root.getRight());
        }

        System.out.println("root = " + root);
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "松江");
        Node node1 = new Node(2, "吴用");
        Node node2 = new Node(3, "卢俊义");
        Node node3 = new Node(5, "关胜");
        Node node4 = new Node(4, "林冲");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        //先序遍历
        System.out.println("二叉树的先序遍历");
        binaryTree.preTravel(root);

        //中序遍历
        System.out.println("二叉树的中序遍历");
        binaryTree.midTravel(root);

        //后序遍历
        System.out.println("二叉树的后序遍历");
        binaryTree.afterTravel(root);
    }
}


