package com.springchang.datastructures.stack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Java版本计算器
 *
 * @author : 张翠山
 *
 * @date 2020/12/25
 */
public class GuiCalculator {

    private JButton[] jButtons = new JButton[16];

    private String expression = "";

    private ReversePolishNotation reversePolishNotation = new ReversePolishNotation();


    /**
     * 构造函数
     */
    public GuiCalculator() {
        JFrame jFrame = new JFrame("Java版本计算器");
        JPanel jpanel=new JPanel();    //创建面板

        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("楷体",Font.BOLD,16));

        //指定面板的布局为GridLayout，4行4列，间隙为5
        jpanel.setLayout(new GridLayout(4,4,5,5));

        jButtons[0] = new JButton("7");
        jButtons[1] = new JButton("8");
        jButtons[2] = new JButton("9");
        jButtons[3] = new JButton("/");
        jButtons[4] = new JButton("4");
        jButtons[5] = new JButton("5");
        jButtons[6] = new JButton("6");
        jButtons[7] = new JButton("*");
        jButtons[8] = new JButton("1");
        jButtons[9] = new JButton("2");
        jButtons[10] = new JButton("3");
        jButtons[11] = new JButton("-");
        jButtons[12] = new JButton("0");
        jButtons[13] = new JButton(".");
        jButtons[14] = new JButton("=");
        jButtons[15] = new JButton("+");

        for (int i = 0; i < jButtons.length; i++) {
            jpanel.add(jButtons[i]);
            jButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String actionCommand = e.getActionCommand();

                    //用户击中等号，计算表达式
                    if("=".equalsIgnoreCase(actionCommand)) {
                        String str = jTextField.getText().trim();

                        double resutl = ReversePolishNotation.calc(str);
                        DecimalFormat fmt = new DecimalFormat("##0.00");

                        jTextField.setText(str + "=" + fmt.format(resutl));
                    } else {
                        //用户击中其他数字，向表达式添加数字
                        expression += actionCommand;
                        jTextField.setText(expression);
                    }
                }
            });
        }

        jFrame.add(jTextField, BorderLayout.NORTH);
        jFrame.add(jpanel, BorderLayout.CENTER);    //添加面板到容器

        jFrame.setBounds(300,200,250,300);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int calculator(String expression) {
        //定义一个栈，数字栈
        java.util.Stack<String> numsStack = new java.util.Stack<>();
        java.util.Stack<String> operStack = new java.util.Stack<String>();

        //解析出表达式
        List<String> list = parse(expression);

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);

            //判断字符串是数字还是操作符
            if(!isOperation(str)) {
                //是数字则直接入数字栈
                numsStack.push(str);
            } else {
                //判断操作符栈是否为空，为空则直接入栈
                if(operStack.isEmpty()) {
                    operStack.push(str);
                } else {
                    //比较操作符栈中的操作符和当前扫描到的操作符，谁的优先权大
                    if(priority(str)-priority(operStack.peek()) <= 0) {
                        //当前操作符优先权小于等于操作栈栈顶的优先权,则运算，将结果压入数据栈中
                        int number1 = Integer.parseInt(numsStack.pop());  //操作数1
                        int number2 = Integer.parseInt(numsStack.pop());  //操作数2
                        String operation = operStack.pop(); //操作符

                        //运算并拿到结果
                        int result = calculate(number1, number2, operation);

                        //将结算得到的结果压入数字栈
                        numsStack.push(result+"");
                        //将当前运算符压入操作栈
                        operStack.push(str);
                    } else {
                        //当前的操作符高于栈顶操作符，则直接入操作符栈
                        operStack.push(str);
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

            int num1 = Integer.parseInt(numsStack.pop());
            int num2 = Integer.parseInt(numsStack.pop());
            String operation = operStack.pop(); //操作符
            //运算并拿到结果
            int result = calculate(num1, num2, operation);
            //将结算得到的结果压入数字栈
            numsStack.push(result+"");
        }

        return Integer.parseInt(numsStack.peek());
    }

    /**
     * 解析表达式,将字符串解析为字符串数组
     * @param expression
     * @return List数组
     */
    public static List<String> parse(String expression) {
        List<String> list = new ArrayList<String>();

        int index = 0;
        while (index < expression.length()) {
            char ch = expression.charAt(index);
            if(isNumber(ch)) {
                //如果是数字则，判断截止位置,index是数字开始位置，自己找到结束位置
                int endIndex = index;
                int i = index + 1;
                for (; i < expression.length(); i++) {
                    char ch1 = expression.charAt(i);
                    if(!isNumber(ch1)) {
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
            } else {
                //如果是操作符，则直接添加，index后移
                list.add(ch+"");
                index++;
            }
        }

        return list;
    }


    /**
     * 判断是否为数字
     * @param ch
     * @return
     */
    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 是否操作符
     * @param ch
     * @return
     */
    public static boolean isOperation(String ch) {
        return "+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch);
    }

    /**
     * 计算计算符优先权
     * @param operation 操作符
     * @return
     */
    public static int priority(String operation) {
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
     * 四则计算两个数
     * @param number1 数字1
     * @param number2 数字2
     * @param operation 运算符
     * @return
     */
    public static int calculate(int number1, int number2, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number2 - number1;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number2 / number1;
                break;
            default:
                throw new RuntimeException("操作符号错误");
        }
        return result;
    }


    public static void main(String[] args) {
        new GuiCalculator();
    }
}
