package com.springchang.datastructures.queue;

/**
 * @author : 张翠山
 * @Descption: 环形队列的实现
 * @date 2020/12/23
 */
public class CircleArrayQueue implements Queue {

    //容器
    private int[] arr;

    //队列的长度
    private int maxSize;

    //指向队列头部的指针
    private int front;

    //指向队列尾部的指针
    private int rear;

    public CircleArrayQueue() {
        this(16);
    }

    public CircleArrayQueue(int capacity) {
        arr = new int[capacity];
        maxSize = capacity;
        front = 0;
        rear = 0;
    }


    //判断队列是否已满
    private boolean isFull() {
        return (rear+1)%maxSize == front;
    }

    //判断队列是否为空
    private boolean isEmpty() {
        return rear == front;
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

        arr[rear] = e;
        rear = (rear+1)%maxSize;

        return true;
    }

    @Override
    public int remove() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能移除头部数据");
        }
        int data = arr[front];
        front = (front+1)%maxSize;
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
        if(rear >= front) {
            for (int i = front; i < rear; i++) {
                if(i < rear-1) {
                    sb.append(arr[i]).append(",");
                } else {
                    sb.append(arr[i]);
                }
            }
        } else {
            for (int i = front; i < rear+maxSize; i++) {
                if(i < rear+maxSize-1) {
                    sb.append(arr[i%maxSize]).append(",");
                } else {
                    sb.append(arr[i%maxSize]);
                }
            }
        }

        sb.append("]");
        
        return sb.toString();
    }
}
