package com.company.nowcoder;

import java.util.*;

/**
 * 题目描述
 *  给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，
 * 一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，
 * 同时停靠在火车站的列车中，
 * 只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 */
public class stackPlan {
    static Stack<Integer> stackIn;
    static Stack<Integer> stackOut;
    static Set<String> set;
    static int[] queue;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            set = new TreeSet<>();
            stackIn = new Stack<>();//入栈栈
            stackOut = new Stack<>();//出栈栈
            queue = new int[n];

            //倒序入栈，这样从出栈出栈的时候就是正序的
            for (int i = n-1; i >=0; i--) {
                queue[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                stackIn.push(queue[i]);
            }

            dfs("");
            for (String s : set){
                System.out.println(s);
            }
        }
    }

    /**
     * 递归过程中有四种情况：
     *  1. 入栈不空，出栈不空，此时有两种选择：
     *                  （1）出栈中出栈，加入到出栈字符串，相当于彻底出栈
     *                  （2）入栈栈顶加入出栈栈，等待之后第二次出栈
     *  2. 入栈空，出栈不空，此时相当于把出栈栈中元素全部出栈加入字符串，完成一次递归
     *  3. 入栈不空，出栈空，此时把一个入栈元素加入到出栈栈中
     *  4. 都空，返回出栈字符串
     * @param res
     */
    public static void dfs(String res){
        //入栈队列出栈队列都为空说明全部出栈
        if (stackOut.isEmpty() && stackIn.isEmpty()){
            set.add(res.trim());
            return;
        }
        //入栈栈不空，说明还可以出栈
        if (!stackIn.isEmpty()){
            //一个元素出栈，加入出栈队列
            stackOut.push(stackIn.pop());
            dfs(res);
            //恢复现场
            stackIn.push(stackOut.pop());
        }
        //出栈栈不空，说明出栈未完全
        if (!stackOut.isEmpty()){
            //暂时保留出栈栈顶元素
            int temp = stackOut.pop();
            //加入出栈字符串
            dfs(res + " " + temp);
            //恢复现场
            stackOut.push(temp);
        }
    }
}
