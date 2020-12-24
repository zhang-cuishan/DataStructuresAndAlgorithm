package com.springchang.datastructures.stack;

/**
 * Stack栈接口定义
 * @author : 张翠山
 */
public interface Stack {

    /**
     * 测试堆栈是否为空
     * @return
     */
    boolean isEmpty();


    /**
     * 测试堆栈是否已满
     * @return
     */
    boolean isFull();


    /**
     * 查看堆栈顶部的对象，但不从堆栈中移除它
     * @return
     */
    int peek();

    /**
     *  移除堆栈顶部的对象，并作为此函数的值返回该对象
     * @return
     */
    int pop();

    /**
     * 把项压入堆栈顶部
     * @param item
     * @return
     */
    int push(int item);

    /**
     * 返回对象在堆栈中的位置，以 1 为基数
     * @param object
     * @return
     */
    int search(int object);
}
