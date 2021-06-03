package com.springchang.datastructures.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;

    protected int size;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E[] objects) {
        for (E object : objects) {
            insert(object);
        }
    }

    /**
     * 二叉树的查找
     * @param e
     * @return
     */
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;

        while(current != null) {
            if(current.element.compareTo(e) > 0) {
                current = current.left;
            } else if(current.element.compareTo(e) < 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean insert(E e) {

        if(root == null) {
            root = createNode(e);
        } else {

            TreeNode node = createNode(e);

            //查找要插入的正确位置
            TreeNode parent = null;
            TreeNode current = root;

            while (current != null) {
                if(current.element.compareTo(e) > 0) {
                    parent = current;
                    current = current.left;
                } else if(current.element.compareTo(e) < 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }

            if(parent.element.compareTo(e) > 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }

        size++;
        return true;
    }

    private TreeNode<E> createNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean delete(E e) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 实现中序遍历
     */
    @Override
    public void inorder() {
        inorder(root);
    }

    /**
     * 中序遍历的具体实现
     * @param treeNode 子树根节点
     */
    private void inorder(TreeNode treeNode) {
        if(treeNode == null)
            return;
        inorder(treeNode.left);
        System.out.print(treeNode.element+"\t");
        inorder(treeNode.right);
    }

    /**
     * 实现后续遍历
     */
    @Override
    public void postorder() {
        postorder(root);
    }

    /**
     * 后续遍历的具体实现
     * @param treeNode
     */
    public void postorder(TreeNode treeNode) {
        if(treeNode == null)
            return;

        postorder(treeNode.left);
        postorder(treeNode.right);
        System.out.print(treeNode.element+"\t");
    }

    /**
     * 实现先序遍历
     */
    @Override
    public void preorder() {
        preorder(root);
    }

    /**
     * 先序遍历的具体实现
     * @param treeNode 根节点
     */
    private void preorder(TreeNode treeNode) {
        if(treeNode == null)
            return;

        System.out.print(treeNode.element+"\t");
        preorder(treeNode.left);
        preorder(treeNode.right);
    }

    public List<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();

        TreeNode current = root;
        while(current != null) {
            list.add(current);

            if(current.element.compareTo(e) > 0) {
                current = current.left;
            } else if(current.element.compareTo(e) < 0) {
                current = current.right;
            } else {
                //已经找到，中断路径
                return list;
            }
        }

        list.clear();
        return  list;
    }

    public static class TreeNode<E extends Comparable<E>> {
        E element;

        TreeNode<E> left;

        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }
}
