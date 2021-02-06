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

    //前序查找
    public Node preSearch(Node node, int id) {
        System.out.println("先序查询");
        if(node.getId() == id) {
            return node;
        }

        Node findNode = null;
        if (node.getLeft() != null) {
            findNode = preSearch(node.getLeft(), id);
        }
        if(findNode != null) {
            return findNode;
        }

        if(node.getRight() != null) {
            findNode = preSearch(node.getRight(), id);
        }
        if(findNode != null) {
            return findNode;
        }

        return null;
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

    //中序查找
    public Node midSearch(Node node, int id) {

        Node findNode = null;
        if (node.getLeft() != null) {
            findNode = midSearch(node.getLeft(), id);
        }
        if(findNode != null) {
            return findNode;
        }

        System.out.println("中序查询");
        if(node.getId() == id) {
            return node;
        }

        if(node.getRight() != null) {
            findNode = midSearch(node.getRight(), id);
        }
        if(findNode != null) {
            return findNode;
        }

        return null;
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

    //后序查找
    public Node afterSearch(Node node, int id) {

        Node findNode = null;
        if (node.getLeft() != null) {
            findNode = afterSearch(node.getLeft(), id);
        }
        if(findNode != null) {
            return findNode;
        }

        if(node.getRight() != null) {
            findNode = afterSearch(node.getRight(), id);
        }
        if(findNode != null) {
            return findNode;
        }

        System.out.println("后序查询");
        if(node.getId() == id) {
            return node;
        }

        return null;
    }

    public void delNode(Node node, int id) {
        if(node.getLeft() == null && node.getRight() == null && node.getId() == id) {
            node = null;
        }

        if(node.getLeft() != null && node.getLeft().getId() == id) {
            node.setLeft(null);
            return;
        }
        if(node.getRight() != null && node.getRight().getId() == id) {
            node.setRight(null);
            return;
        }

        if(node.getLeft() != null) {
            delNode(node.getLeft(), id);
        }
        if(node.getRight() != null) {
            delNode(node.getRight(), id);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "松江");
        Node node1 = new Node(2, "吴用");
        Node node2 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node3 = new Node(5, "关胜");

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

        int key = 5;
        System.out.println("先序搜索数字 = " + key);
        Node resultNode1 = binaryTree.preSearch(root, key);
        System.out.println("node = " + resultNode1);

        System.out.println("中序搜索数字 = " + key);
        Node resultNode2 = binaryTree.midSearch(root, key);
        System.out.println("node = " + resultNode2);

        System.out.println("后序搜索数字 = " + key);
        Node resultNode3 = binaryTree.afterSearch(root, key);
        System.out.println("node = " + resultNode3);

        System.out.println("删除前二叉树前序遍历结果：");
        binaryTree.preTravel(root);

        binaryTree.delNode(root, 4);
        System.out.println("删除后二叉树前序遍历结果：");
        binaryTree.preTravel(root);
    }
}


