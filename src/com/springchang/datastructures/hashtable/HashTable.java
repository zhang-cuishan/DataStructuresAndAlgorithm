package com.springchang.datastructures.hashtable;

/**
 * @author : 张翠山
 */
public class HashTable {

    private EmpLinkedList[] empLinkedListArray;

    private int size;

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.size = capacity;
        empLinkedListArray = new EmpLinkedList[capacity];

        for (int i = 0; i < empLinkedListArray.length; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 哈希函数
     * @param id
     * @return
     */
    private int hash(int id) {
        return id%size;
    }

    public void add(User user) {
        empLinkedListArray[hash(user.no)].add(user);
    }

    public void list() {
        for (EmpLinkedList empLinkedList : empLinkedListArray) {
            empLinkedList.list();
        }
    }

    //根据输入的id,查找雇员
    public void findEmpById(int id) {
        int hashCode = hash(id);

        User user = empLinkedListArray[hashCode].findEmpById(id);

        if(user == null) {
            System.out.println("id为"+id+"的用户不存在");
        } else {
            System.out.println("用户数据找到：" + user.toString());
        }
    }
}
