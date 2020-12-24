package com.springchang.datastructures.stack;

/**
 * @author : 张翠山
 * 链表实现的栈
 */
public class LinkedStatck implements Stack {

    //栈顶指针
    private Node top = null;

    //栈元素个数
    private int n = 0;

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int peek() {
        if(top == null) {
            throw new RuntimeException("栈已经为空，不能取出数据");
        }
        return top.data;
    }

    @Override
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈已经为空，不能继续弹出");
        }
        int data = top.data;
        top = top.next;
        n--;
        return data;
    }

    @Override
    public int push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        n++;
        return 0;
    }

    @Override
    public int search(int object) {
        int index = -1;
        Node curNode = top;
        for (int i = 0; i < n; i++) {
            if(curNode.data == object) {
                return i+1;
            }
            curNode = curNode.next;
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        Node currentNode = top;
        for (int i = 0; i < n; i++) {
            sb.append(currentNode.data);
            currentNode = currentNode.next;
            if(i != n-1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    class Node {
        int data;

        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
