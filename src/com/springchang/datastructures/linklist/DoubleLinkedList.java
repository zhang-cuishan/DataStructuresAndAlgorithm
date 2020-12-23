package com.springchang.datastructures.linklist;

/**
 * @author : 张翠山
 * 双向链表
 */
public class DoubleLinkedList {

    private HeroNode header = null;

    public DoubleLinkedList() {
        header = new HeroNode(-1, "", "");
    }

    public boolean add(HeroNode newNode) {
        if(header == null) {
            return false;
        }
        HeroNode currentNode = header;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;

        return true;
    }

    public boolean update(HeroNode updateNode) {
        if(header.next == null) {
            System.out.println("链表为空，不能修改");
        }


        return true;
    }

    public boolean remove(int delNo) {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        HeroNode currentNode = header.next;
        sb.append("[");
        while(currentNode != null) {
            sb.append("{")
                    .append(currentNode.no)
                    .append(",")
                    .append(currentNode.name)
                    .append(",")
                    .append(currentNode.nickName)
                    .append("}");
            currentNode = currentNode.next;
            if(currentNode != null) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}

class HeroNode {
    int no;

    String name;

    String nickName;

    //下一个节点
    HeroNode next;

    //上一个节点
    HeroNode pre;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
}
