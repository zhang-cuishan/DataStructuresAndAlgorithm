package com.springchang.datastructures.stack;

/**
 * @author : 张翠山
 * Java实现计算器
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3+3";

        //定义一个栈，数字栈
        Stack numsStack = new ArrayStack(10);
        Stack operStack = new ArrayStack(10);
        
        //扫描字符串表达式
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            //判断字符串是数字还是操作符
            if(isNumber(ch)) {
                //是数字则直接入数字栈
                numsStack.push(ch-'0');
            } else {
                //判断操作符栈是否为空，为空则直接入栈
                if(operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    //比较操作符栈中的操作符和当前扫描到的操作符，谁的优先权大
                    if(priority(ch)-priority((char) operStack.peek()) <= 0) {
                        //当前操作符优先权小于等于操作栈栈顶的优先权,则运算，将结果压入数据栈中
                        int number1 = numsStack.pop();  //操作数1
                        int number2 = numsStack.pop();  //操作数2
                        char operation = (char) operStack.pop(); //操作符

                        //运算并拿到结果
                        int result = calculate(number1, number2, operation);

                        //将结算得到的结果压入数字栈
                        numsStack.push(result);
                        //将当前运算符压入操作栈
                        operStack.push(ch);
                    } else {
                        //当前的操作符高于栈顶操作符，则直接入操作符栈
                        operStack.push(ch);
                    }
                }
            }
        }

        //扫描字符串完毕,遍历数据栈和操作符栈，计算俩里面的值,数据栈只有一个数据的时候就是最终的结果
        while(true) {
            //如果符号栈为空，则认为遍历结束
            if(operStack.isEmpty()) {
                break;
            }

            int num1 = numsStack.pop();
            int num2 = numsStack.pop();
            char operation = (char) operStack.pop(); //操作符
            //运算并拿到结果
            int result = calculate(num1, num2, operation);
            //将结算得到的结果压入数字栈
            numsStack.push(result);
        }

        System.out.printf("%s = %d\n", expression, numsStack.peek());
    }

    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static int priority(char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = 1;
                break;
            case '-':
                result = 1;
                break;
            case '*':
                result = 2;
                break;
            case '/':
                result = 2;
                break;
            default:
                throw new RuntimeException("操作符号错误");
        }
        return result;
    }


    /**
     * 计算
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
}
