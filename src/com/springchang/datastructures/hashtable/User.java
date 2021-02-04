package com.springchang.datastructures.hashtable;

/**
 * @author : 张翠山
 */
public class User {
    int no;

    String name;

    String address;

    User next;

    public User() {}

    public User(int no, String name, String address) {
        this.no = no;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
