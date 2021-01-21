package com.springchang.datastructures.gernaration;

/**
 * @author : 张翠山
 */
public class GenericStackTest<E> {

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<Integer>(5);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        stack.push(17);
        stack.push(18);
        stack.push(19);
        stack.push(20);

        while(!stack.isEmpty()) {
            System.out.println("stack = " + stack.pop());
        }
    }
}
