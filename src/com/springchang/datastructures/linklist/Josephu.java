package com.springchang.datastructures.linklist;

/**
 * 解决约瑟夫问题
 *
 * @author : 张翠山
 */
public class Josephu{

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(7);
        circleSingleLinkedList.countBoy(1, 3);
    }
}

//构造环形单向链表,并操作其中的数据
class CircleSingleLinkedList {
    //第一个节点,没有头节点的链表
    Boy first = null;

    /**
     * 添加孩子的操作
     * @param nums 孩子数量
     */
    public void addBoys(int nums) {
        if(nums < 1) {
            throw new RuntimeException("nums范围错误");
        }

        //循环nums给队列添加数据
        Boy curBoy = null; //辅助指针

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);

            //如果boy为第一个数，则让first指向第一个节点
            if(i == 1) {
                first = boy;
                first.setNext(boy);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 模拟孩子报数过程
     * @param startNo 开始
     * @param countNum
     */
    public void countBoy(int startNo, int countNum) {
        //判断数据的合法性
        if(startNo < 1 || countNum < 1) {
            System.out.println("参数传递错误");
            return;
        }

        //创建辅助指针,指向first的上一个，也就是最后一个节点
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        //从startNo号孩子开始报数，则移动startNo-1步
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //模拟孩子不断的出圈
        System.out.println("小孩出圈顺序：");
        while (true) {
            if(helper == first) {
                System.out.println("出圈小孩 " + first.getNo());
                break;
            }
            //让孩子报数
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //打印出圈小孩信息
            System.out.println("出圈小孩 " + first.getNo());

            //报数结束，first指向的孩子节点出圈,first后移
            first = first.getNext();
            helper.setNext(first);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        Boy curBoy = first;
        //当前节点的下一个节点指向第一个节点的时候，就表明已经遍历完毕
        do {
            sb.append(curBoy.getNo());
            curBoy = curBoy.getNext();
            if(curBoy != first) {
                sb.append(",");
            }
        } while(curBoy != first);
        sb.append("]");

        return sb.toString();
    }
}


//构造孩子节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
