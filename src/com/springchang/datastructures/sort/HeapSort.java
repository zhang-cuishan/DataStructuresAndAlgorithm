package com.springchang.datastructures.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 张翠山
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        Heap heap = new Heap();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = arr.length-1; i >= 0; i--) {
            arr[i] = heap.remove();
        }
    }

    private static class Heap {
        private List<Integer> list = new ArrayList<Integer>();

        public Heap() {}

        private void add(int data) {
            list.add(data); //向数组追加元素

            int currentIndex = list.size()-1;   //当前指针
            int parentIndex = (currentIndex-1)/2; //父指针
            while(parentIndex >= 0) { //父指针合法
                //判断当前元素和父元素大小，如果当前元素大于
                if(list.get(currentIndex) > list.get(parentIndex)) {
                    swap(currentIndex, parentIndex);
                }
                currentIndex = parentIndex;
                parentIndex = currentIndex/2-1;
            }
        }

        private void swap(int i, int j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        private int remove() {
            if(list == null || list.size() == 0) {
                throw new RuntimeException("数组越界");
            }

            int moveNode = list.get(0);//临时变量，接受根节点
            //将最后一个元素放入第一个元素，然后移除最后一个元素
            list.set(0, list.get(list.size()-1));
            list.remove(list.size()-1);

            int currentIndex = 0; //当前节点指向根节点
            while(currentIndex < list.size()-1) {
                int leftChild = currentIndex*2+1;  //左子节点
                int rightChild = currentIndex*2+2; //右子节点
                if (leftChild > list.size()-1) {
                    break;
                }
                int maxChild = leftChild;
                if(rightChild <= list.size()-1 && list.get(rightChild) > list.get(leftChild)) {
                    maxChild = rightChild;
                }

                //比较当前节点和子节点，如果当前节点小于子节点，则互换
                if(list.get(currentIndex) < list.get(maxChild)) {
                    swap(currentIndex, maxChild);
                }

                currentIndex = maxChild;
            }

            return moveNode;
        }
    }
}
