package com.springchang.datastructures.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : 张翠山
 * @Descption: 测试JDK自带的队列
 * @date 2020]/12/23
 */
public class TestQueue {

    public static void main(String[] args) {
        //测试ArrayQueue
        //testArrayQueue();

        //测试LinkedQueue
        testLinkedQueue();
    }

    //测试数组实现的队列
    public static void testArrayQueue() {
        Queue<String> citys = new ArrayDeque<String>(10);
        citys.add("北京");
        citys.add("上海");
        citys.add("广州");
        citys.add("深圳");
        System.out.println("citys = " + citys);

        //出队列
        citys.remove();
        citys.remove();
        System.out.println("citys = " + citys);
    }

    public static void testLinkedQueue() {
        Queue<String> citys = new LinkedList<String>();
        citys.add("北京");
        citys.add("上海");
        citys.add("广州");
        citys.add("深圳");
        System.out.println("citys = " + citys);

        //出队列
        citys.remove();
        citys.remove();
        System.out.println("citys = " + citys);
    }
}
