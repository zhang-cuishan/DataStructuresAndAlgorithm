package com.springchang.datastructures.linklist;

/**
 * @author : 张翠山
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(new HeroNode(1, "松江", "及时雨"));
        doubleLinkedList.add(new HeroNode(2, "卢俊义", "玉麒麟"));
        doubleLinkedList.add(new HeroNode(3, "吴用", "智多星"));
        doubleLinkedList.add(new HeroNode(4, "公孙胜", "入云龙"));
        doubleLinkedList.add(new HeroNode(5, "关胜", "大刀"));
        System.out.println(doubleLinkedList.toString());


    }
}
