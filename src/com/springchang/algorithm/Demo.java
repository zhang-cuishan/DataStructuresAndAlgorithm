package com.springchang.algorithm;

/**
 * @author : 张仕宗
 * @date 2021/07/24
 * 程序功能： 计算超市指定商品和数量总价
 */
public class Demo {

    private static final long APPLE_PRICE = 8L; //苹果价格,单位是元，如果要求精确度可将存储单位换成分，再将结算最终结果换算成元

    private static final long BERRY_PRICE = 13L; //草莓价格，单位是元

    private static final long MANGO_PRICE = 20L; //芒果价格，单位是元

    public static void main(String[] args) {
        System.out.println("calc(1, 1) = " + calc(1, 1) + "元");
        System.out.println("calc(1, 1) = " + calc(1, 1,10) + "元");
        System.out.println("calcDiscount(1, 2, 3) = " + calcDiscount(1, 2, 3) + "元");
    }

    /**
     * 问题1：请编写一个函数，对于给定的 x 和 y (x 和 y 为大于等于 0 的整数)，计算并返回所购买商品的总价。
     * @param x 苹果数量
     * @param y 草莓数量
     * @return 总价，单位是分
     */
    public static double calc(int x, int y) {
        if(x < 0)
            x = 0;
        if(y < 0) {
            y = 0;
        }
        return x*APPLE_PRICE + y*BERRY_PRICE;
    }

    /**
     * 问题2：请编写一个函数，对于给定的 x、y 和 z (x、y、z 为大于等于 0 的整数)，计算并返回所购买商品的总价。
     * @param x 苹果数量
     * @param y 草莓数量
     * @return 总价，单位是分
     */
    public static double calc(int x, int y, int z) {
        if(x < 0)
            x = 0;
        if(y < 0) {
            y = 0;
        }
        if(z < 0) {
            z = 0;
        }
        return x*APPLE_PRICE + y*BERRY_PRICE + z*MANGO_PRICE;
    }

    /**
     * 问题2：请编写一个函数，对于给定的 x、y 和 z (x、y、z 为大于等于 0 的整数)，计算打折之后所购买商品的总价。
     * @param x 苹果数量
     * @param y 草莓数量
     * @return 总价，单位是分
     */
    public static double calcDiscount(int x, int y, int z) {
        double discount = 0.8;
        if(x < 0)
            x = 0;
        if(y < 0) {
            y = 0;
        }
        if(z < 0) {
            z = 0;
        }
        return (x*APPLE_PRICE + y*BERRY_PRICE*discount + z*MANGO_PRICE);
    }
}
