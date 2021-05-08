package com.company.normal;

import java.util.*;

public class removeKdigits {
    /**
     * 402. 移掉K位数字
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * <p>
     * 注意:
     * <p>
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     * 示例 1 :
     * <p>
     * 输入: num = "1432219", k = 3
     * 输出: "1219"
     * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
     * 示例 2 :
     * <p>
     * 输入: num = "10200", k = 1
     * 输出: "200"
     * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     * 示例 3 :
     * <p>
     * 输入: num = "10", k = 2
     * 输出: "0"
     * 解释: 从原数字移除所有的数字，剩余为空就是0。
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }

    /**
     * 用一个双向队列保留字符串
     * 遍历字符串的时候（依次入队），遇到高位小于低位（设从左到右位变高）
     * 删除低位（出队）
     * 直到删除k位，
     * 每删除一位k--,若遍历完后没有删除完(k!=0)
     * 直接删除后k位
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits2(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && c < deque.peekLast()) {
                deque.pollLast();//出队
                --k;
            }
            deque.addLast(c);//入队
        }

        StringBuilder s = new StringBuilder();
        int m = deque.size() - k;//如果k没有删除完，则相当于保留没有删除完部分的前m位
        while (!deque.isEmpty() && m > 0) {
            char c = deque.pollFirst();
            if (c != '0' || s.length() != 0) {
                s.append(c);
                --m;
            }

        }
        if (s.length() == 0)
            return "0";
        return s.toString();
    }

    public static void main(String... args) {
        System.out.println(new removeKdigits().removeKdigits2("1432219", 3));
    }
}
