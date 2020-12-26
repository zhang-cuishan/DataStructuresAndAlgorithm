package com.springchang.datastructures.stack;

import java.util.*;
import java.util.Stack;

/**
 * 完整的逆波兰表达式算法
 * 1).支持四则运算以及括号解析
 * 2).支持多位数，支持浮点数
 * 3).兼容处理，过滤任何空白字符，包括：空格、制表符、换页符
 * @author : 张翠山
 */
public class ReversePolishNotation {

    //运算逆波兰式
    public static void main(String[] args) {
        System.out.println("欢迎使用逆波兰表达式计算器!");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入表达式:");
            String str = scanner.nextLine();
            //用正则表达式去掉空白符，包括空格、制表符、换页符等
            str = str.trim().replaceAll("\\s","");
            double result = calculate(toSuffixExpression(parse(str)));
            System.out.printf("%s = %f\n", str, result);
            System.out.println(result);
        }
    }

    /**
     * 中缀表达式转后缀表达式(调度场算法)
     * @param midExpression
     * @return
     */
    private static List<String> toSuffixExpression(List<String> midExpression) {
        //定义一个队列，存放后缀表达式
        List<String> queue = new LinkedList<String>();
        java.util.Stack<String> stack = new java.util.Stack<String>();

        //扫描中缀表达式
        for (int i = 0; i < midExpression.size(); i++) {
            String data = midExpression.get(i);
            //判断元素是数字还是操作符
            if(isNumber(data)) {//是一个数字，则直接推入队列
                queue.add(data);
            } else if(isOperation(data)) { //当前字符串是一个操作符
                //判断栈是否有数据,如果栈为空或者栈顶数据为左括号，则直接入栈
                if(stack.isEmpty() || "(".equals(stack.peek())) {
                    stack.push(data);
                } else {
                    //栈中有数据，则那当前操作符和栈顶操作符比对权重
                    String top = stack.peek();
                    while(priority(data)-priority(top) <= 0 && !stack.isEmpty()) {
                        //如果当前操作符的权重小于等于栈顶的操作符权限，则将栈顶的操作符不断弹出，推送到队列中去
                        top = stack.pop();
                        queue.add(top);
                    }
                    stack.push(data);
                }
            } else if("(".equals(data)) {
                //如果这是一个左括号，则直接压入栈中
                stack.push(data);
            } else if(")".equals(data)) {
                //如果这是一个右边括号，那么不断的弹出操作符，放入队列中，直到栈顶元素为左括号为止
                while(!stack.isEmpty() && !"(".equals(stack.peek())) {
                    queue.add(stack.pop());
                }
                stack.pop();
            }
        }

        //扫描完毕中缀表达式，将栈剩余的数据推入队列
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    /**
     * 运算后缀表达式的最终结果
     * @param suffixExpressionList 后缀表达式
     * @return
     */
    private static double calculate(List<String> suffixExpressionList) {
        double result = 0;

        //定义一个栈
        Stack<String> numStack = new java.util.Stack<String>();

        //扫描后缀表达式
        for(final String str : suffixExpressionList) {
            if(isNumber(str)) {
                //如果是一个数字，则入站
                numStack.push(str);
            } else if(isOperation(str)) {
                //如果是一个操作符，则计算
                double num1 = Double.parseDouble(numStack.pop());
                double num2 = Double.parseDouble(numStack.pop());
                double temp = 0;
                if("+".equals(str)) {
                    temp = num1 + num2;
                } else if("-".equals(str)) {
                    temp = num2 - num1;
                } else if("*".equals(str)) {
                    temp = num1 * num2;
                } else if("/".equals(str)) {
                    temp = num2 / num1;
                }

                //将计算到的结果入栈
                numStack.push(temp+"");
            }
        }

        return Double.parseDouble(numStack.peek());
    }

    /**
     * 计算操作符的权重
     * @param operation
     * @return
     */
    private static int priority(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                throw new RuntimeException("操作符号错误");
        }
        return result;
    }

    /**
     * 解析字符串,将字符串解析成单个元素，推入List队列中
     * @param expression
     * @return
     */
    public static List<String> parse(String expression) {
        //替掉表达式中的空白符
        expression = expression.replaceAll("\\s", "");

        List<String> list = new ArrayList<String>();

        int index = 0;
        while (index < expression.length()) {
            char ch = expression.charAt(index);
            //如果扫描到的单个字符是数字或者小数点
            if(isNumber(ch) || '.' == ch) {
                //如果是数字则，判断截止位置,index是数字开始位置，自己找到结束位置
                int endIndex = index;
                int i = index + 1;
                for (; i < expression.length(); i++) {
                    char ch1 = expression.charAt(i);
                    if(!isNumber(ch1) && '.'!= ch1) {
                        endIndex = i;
                        break;
                    }
                }
                //找到当前数字的起止位置
                if(i == expression.length()) {
                    //已经扫描到尾部
                    endIndex = expression.length();
                }
                String numberStr = expression.substring(index, endIndex);
                list.add(numberStr);
                //指标后移
                index = endIndex;
            } else if(isOperation(ch+"")) {//如果扫描的字符是操作符
                //如果是操作符，则直接添加，index后移
                list.add(ch+"");
                index++;
            } else if ('(' == ch || ')' == ch) {//如果扫描的字符是左括号或者右括号
                list.add(ch+"");
                index++;
            }
        }

        return list;
    }


    /**
     * 判断字符串是否是数字,处理浮点数
     * @param str
     * @return
     */
    private static boolean isNumber(String str) {
        str = str.replace(".", "");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!isNumber(ch)) {
                return false;
            }
        }

        return true;
    }
    /**
     * 判断单个字符是否是一个数字
     * @param ch
     * @return
     */
    private static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 是否操作符,其中括号不算操作符
     * @param ch
     * @return
     */
    private static boolean isOperation(String ch) {
        return "+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch);
    }
}
