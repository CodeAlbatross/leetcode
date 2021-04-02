package com.company.normal;

import java.util.*;

public class removeDuplicateLetters {
    /**
     * 316. 去除重复字母
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "bcabc"
     * 输出："abc"
     * 示例 2：
     * <p>
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        //保存s中每个字符的数量
        int[] chars = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            ++chars[s.charAt(i) - 'a'];
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            //约束条件，队列不空，队尾元素在整个字符串中有相同元素，高位（遍历的字符）小于低位（队尾）（设右边高位），遍历的字符未入队时，队尾出队
            while (!deque.isEmpty() && c < deque.peekLast() && chars[deque.peekLast() - 'a'] > 1 && !deque.contains(c)) {
                //出队
                --chars[deque.peekLast() - 'a'];
                deque.pollLast();

            }
            //遍历的字符未入队时，入队
            if (!deque.contains(c)) {
                deque.addLast(c);
            } else {
                --chars[c - 'a'];
            }

        }
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String... args) {
        System.out.println(new removeDuplicateLetters().removeDuplicateLetters("bbcaac"));
    }
}
