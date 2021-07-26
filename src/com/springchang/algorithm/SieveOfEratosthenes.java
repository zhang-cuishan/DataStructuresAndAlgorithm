package com.springchang.algorithm;

/**
 * @筛选法求质数
 * @date 2021/07/27
 * @author 张翠山
 */
public class SieveOfEratosthenes {

    public static void main(String[] args) {
        boolean[] numbers = new boolean[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = true;
        }

        numbers[0] = false;
        numbers[1] = false;

        //开始筛选
        for (int i = 2; i < numbers.length; i++) {
            int N = numbers.length%i==0 ? numbers.length/i-1 : numbers.length/i;
            for (int j = 2; j <= N; j++) {
                numbers[i*j] = false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]) {
                System.out.print(i + "\t");
            }
        }
    }
}
