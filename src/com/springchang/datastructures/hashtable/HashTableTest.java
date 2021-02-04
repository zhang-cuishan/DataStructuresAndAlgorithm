package com.springchang.datastructures.hashtable;

/**
 * @author : 张翠山
 */
public class HashTableTest {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add(new User(1, "张翠山1", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(2, "张翠山2", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(3, "张翠山3", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(4, "张翠山4", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(5, "张翠山5", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(6, "张翠山6", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(7, "张翠山7", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(8, "张翠山8", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(9, "张翠山9", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(10, "张翠山10", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(11, "张翠山11", "北京市石景山区京原路7号东方地球物理大厦"));
        hashTable.add(new User(12, "张翠山12", "北京市石景山区京原路7号东方地球物理大厦"));

       // hashTable.list();

        hashTable.findEmpById(22);
    }
}
