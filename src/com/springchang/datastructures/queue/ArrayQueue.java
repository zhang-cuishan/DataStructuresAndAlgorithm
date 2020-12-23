package com.springchang.datastructures.queue;

/**
 * @author : 张翠山
 * @Descption:
 * @date 2020/12/23
 */
public class ArrayQueue implements Queue {

    //容器
    private int[] arr;

    //队列的长度
    private int maxSize;

    //指向队列头部的指针
    private int front;

    //指向队列尾部的指针
    private int rear;

    public ArrayQueue() {
        this(16);
    }

    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        maxSize = capacity;
        front = -1;
        rear = -1;
    }


    //判断队列是否已满
    private boolean isFull() {
        return rear == maxSize-1;
    }

    //判断队列是否为空
    private boolean isEmpty() {
        return rear == front?true:false;
    }

    /**
     * 将指定的元素插入此队列在成功时返回 true
     * @param e
     * @return
     */
    @Override
    public boolean add(int e) {
        if(isFull()) {
            throw new RuntimeException("队列已满，不能继续添加");
        }
        arr[++rear] = e;
        return true;
    }

    @Override
    public int remove() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能移除头部数据");
        }
        int data = arr[++front];
        return data;
    }

    /**
     *  获取，但是不移除此队列的头。
     * @return
     */
    @Override
    public int element() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能获取头部数据");
        }
        return arr[rear];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = front+1; i <= rear; i++) {
            if(i < rear) {
                sb.append(arr[i]).append(",");
            } else {
                sb.append(arr[i]);
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
}
