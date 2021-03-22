package com.company.normal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 */
public class _227_calculate {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';//用一个字符保存前一个符号位代替符号栈
        int len = s.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0'){
                num = c - '0' + num * 10;
            }
            if ((c < '0' && c != ' ') || i == len - 1){
                switch (sign){
                    //符号为+将数字直接入栈
                    case '+' -> stack.push(num);
                    //符号为
                    // -将数字取反入栈
                    case '-' -> stack.push(-num);
                    // * 和 / 直接计算入栈
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                //num置零
                num = 0;
                //记录当前符号
                sign = c;
            }
        }
        int ret=0;
        //将栈中剩下的数字相加即为结果
        while (!stack.isEmpty()){
            ret+=stack.pop();
        }
        return ret;
    }
}
