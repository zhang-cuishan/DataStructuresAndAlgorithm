package com.springchang.datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 逆波兰表达式
 * @author : 张翠山
 */
public class PolandNotation {

    //运算逆波兰式
    public static void main(String[] args) {
        String expression = "12+4*5+3-";
        List<String> list = parse(expression);

        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        //从左到右扫描表达式
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i).charAt(0);

            if(isNumber(ch)) {
                //是一个数
                stack.push(ch-'0');
            } else {
                //是操作符，弹出栈来，计算
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = calculate(num1, num2, ch);
                stack.push(result);
            }
        }

        System.out.println("stack = " + stack.peek());
    }

    /**
     * 解析字符串
     * @param str
     * @return
     */
    private static List<String> parse(String str) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i)+"");
        }

        return list;
    }

    /**
     * 计算俩数
     * @param number1
     * @param number2
     * @param operation
     * @return
     */
    public static int calculate(int number1, int number2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number2 - number1;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number2 / number1;
                break;
            default:
                throw new RuntimeException("操作符号错误");
        }
        return result;
    }

    private static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 是否操作符
     * @param ch
     * @return
     */
    private static boolean isOperation(String ch) {
        return "+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch);
    }
}
