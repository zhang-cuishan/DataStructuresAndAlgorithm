package com.springchang.datastructures.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树的构建
 * @author : 张翠山
 */
public class HuffmanTree {

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        Node root = huffmanTree.createHuffmanTree(new int[]{13, 7, 8, 3, 29, 6, 1});
        huffmanTree.preTravle(root);
    }

    public Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();

        for (int i : arr) {
            nodes.add(new Node(i));
        }

        while (nodes.size() > 1) {
            //对链表进行排序
            Collections.sort(nodes);

            //左子节点
            Node leftNode = nodes.get(0);
            //右子节点
            Node rightNode = nodes.get(1);
            //构建父节点
            Node parentNode = new Node(leftNode.value+rightNode.value, leftNode, rightNode);

            nodes.add(parentNode);

            //原数组中移除当前node
            nodes.remove(0);
            nodes.remove(0);
        }

        if(nodes.isEmpty()) {
            return null;
        }
        return nodes.get(0);
    }

    /**
     * 先序遍历
     * @param root
     */
    public void preTravle(Node root) {
        System.out.println(root.toString());
        if(root.left != null) {
            preTravle(root.left);
        }

        if(root.right != null) {
            preTravle(root.right);
        }
    }

    static class Node implements Comparable<Node> {
        int value;

        Node left;

        Node right;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return value-o.value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(value).append(" ").toString();
        }
    }
}
