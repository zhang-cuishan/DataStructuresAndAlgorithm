package com.springchang.datastructures.stack;

/**
 * @author : 张翠山
 */
public class ArrayStack implements Stack{

    //栈的存储结构,stack数组容器
    private int[] stack;

    //栈的容量，默认是10
    private int maxSize = 10;

    //栈顶指针
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    @Override
    public int peek() {
        if(top == -1) {
            throw new RuntimeException("栈为空，不能读取数据");
        }
        return stack[top];
    }

    @Override
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈已空，不能继续弹栈~~~");
        }

        int data = stack[top];
        top--;
        return data;
    }

    @Override
    public int push(int item) {
        if(isFull()) {
            throw new RuntimeException("栈已满，不能继续添加~~~");
        }

        top++;
        stack[top] = item;

        return 0;
    }

    @Override
    public int search(int object) {
        int index = 0;

        for (int i = top; i >= 0; i--) {
            index++;
            if(stack[i] == object) {
                return index;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if(i != top) {
                sb.append(",");
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
}
