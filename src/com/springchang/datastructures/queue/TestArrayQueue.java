package com.springchang.datastructures.queue;

/**
 * @author : 张翠山
 */
public class TestArrayQueue {

    public static void main(String[] args) {
        testCase2();
    }

    public static void testCase1() {
        Queue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        int data = queue.remove();
        System.out.println("从队列中移除数据: data = " + data);
        System.out.println("队列剩余 : " + queue.toString());

        queue.add(5);
        System.out.printf("添加数据:5, 现在队列的内容是%s\n", queue.toString());
        queue.add(6);
    }

    public static void testCase2() {
        Queue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.remove();
        queue.add(6);
        System.out.println(queue);
    }
}
