package com.springchang.datastructures.gernaration;

/**
 * @author : 张翠山
 */
public class GenericStack<E> {

    private E[] list = (E[]) new Object[16];

    private int n = 0;

    public GenericStack() {
    }

    public GenericStack(int size) {
        this.list = (E[]) new Object[size];
    }

    public int getSize() {
        return n;
    }

    public E peek() {

        if(n < 0) {
            throw new RuntimeException("栈为空");
        }
        E data = list[n];
        return data;
    }

    public E pop() {
        if(n <= 0) {
            throw new RuntimeException("栈为空");
        }
        E data = list[--n];
        return data;
    }

    public void push(E o) {
        if(n >= list.length) {
            E[] newList = (E[]) new Object[list.length*2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
        list[n++] = o;
    }

    public boolean isEmpty() {
        if(n <= 0) {
            return true;
        }
        return false;
    }
}
