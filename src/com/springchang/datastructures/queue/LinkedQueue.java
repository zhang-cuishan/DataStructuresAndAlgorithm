package com.springchang.datastructures.queue;

/**
 * @author : 张翠山
 */
public class LinkedQueue implements Queue {

    //定义头部
    Node header = null;

    public LinkedQueue() {
        this.header = new Node(0);
    }

    @Override
    public boolean add(int e) {
        if(header == null) {
            return false;
        }

        //待插入的节点
        Node newNode = new Node(e);

        //定义一个指针，从头指针开始指向，并遍历寻找这个指针
        Node temp = header;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        return true;
    }

    @Override
    public int remove() {
        //判断header是否为空,header节点是存在的
        if(header.next == null) {
            throw new RuntimeException("队列节点为空,不能移除");
        }

        int data = header.item;
        header.next = header.next.next;
        return data;
    }

    @Override
    public int element() {
        if(header.next == null) {
            return -1;
        }
        return header.next.item;
    }

    //定义节点，内部类
    static final class Node {
        int item;

        Node prev;

        Node next;

        Node(int item) {
            this.item = item;
        }
    }

    //遍历输出队列
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node temp = header.next;
        while(temp != null) {
            sb.append(temp.item);
            temp = temp.next;
            if(temp != null) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
