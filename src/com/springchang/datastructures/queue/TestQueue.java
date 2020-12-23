package com.springchang.datastructures.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author : 张翠山
 * @Descption: 测试JDK自带的队列
 * @date 2020]/12/23
 */
public class TestQueue {

    public static void main(String[] args) {
        //测试ArrayQueue
//        testArrayQueue();

        //测试LinkedQueue
        //testLinkedQueue();

        testCircleQueue();
    }

    //测试数组实现的队列
    public static void testArrayQueue() {
        java.util.Queue<String> citys = new ArrayDeque<String>(10);
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
        java.util.Queue<String> citys = new LinkedList<String>();
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

    public static void testCircleQueue() {
        Queue numbers = new CircleArrayQueue(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);


        //移除一个元素
//        numbers.remove();
//        numbers.remove();
//        numbers.remove();
//        numbers.remove();
        System.out.println("numbers = " + numbers.toString());

        //添加一个元素
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);

        System.out.println("numbers = " + numbers.toString());
    }
}
