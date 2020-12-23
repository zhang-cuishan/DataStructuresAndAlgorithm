package com.springchang.datastructures.queue;

/**
 * @author : 张翠山
 * @Descption: queue接口 为了简化模型，只处理int整形参数
 * @date 2020/12/23
 */
public interface Queue {

    boolean add(int e);

    int remove();

    int element();
}
