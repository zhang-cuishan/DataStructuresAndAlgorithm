package com.springchang.datastructures.hashtable;

/**
 * @author : 张翠山
 */
public class EmpLinkedList {

    private User head;

    public void add(User user) {
        if(head == null) {
            head = user;
        } else {
            head.next = user;
        }
    }

    public void list() {
        //必须定义辅助指针，不能乱动原始head的数据
        User temp = head;
        System.out.print("[");
        while(temp != null) {
            System.out.print("temp = " + temp.toString() + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public User findEmpById(int id) {
        //定义辅助指针
        User curNode = head;
        while(curNode != null) {
            if(head.no == id) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }
}
