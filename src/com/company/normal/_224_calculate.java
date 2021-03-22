package com.company.normal;

import java.util.Deque;
import java.util.LinkedList;

public class _224_calculate {
    /**
     * 224. 基本计算器
     * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     *
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     *
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     * @param s
     * @return
     */
    public int calculate(String s) {
        //栈中保存的是每个括号外的符号
        //当一个（前面是-的时候，括号内的所有符号都反转
        //所以每遇到一个-，就将当前符号位入栈，之后将符号位反转计算（内的算式
        //当遇到）的时候就将当符号位出栈恢复到（之前的符号位
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int res = 0;
        int sign = 1;
        int len = s.length();
        int i = 0;
        while (i < len){
            char c = s.charAt(i);
            switch (c){
                case ' ' -> i++;
                case '+' -> {
                    sign = stack.peek();
                    ++i;
                }
                case '-' ->{
                    sign = -stack.peek();
                    ++i;
                }
                case '(' -> {
                    stack.push(sign);
                    ++i;
                }
                case ')' ->{
                    stack.pop();
                    ++i;
                }
                default -> {
                    long num = 0;
                    while (i < len && Character.isDigit(s.charAt(i))){
                        num = num * 10 + s.charAt(i) - '0';
                        ++i;
                    }
                    res += sign * num;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _224_calculate().calculate("2147483647"));
    }
}
