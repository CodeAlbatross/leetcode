package com.company.normal;


import java.util.Comparator;
import java.util.PriorityQueue;

public class reorganizeString {
    /**
     * 767. 重构字符串
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * <p>
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: S = "aab"
     * 输出: "aba"
     * 示例 2:
     * <p>
     * 输入: S = "aaab"
     * 输出: ""
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int[] c = new int[26];
        //统计每个字母出现的次数
        for (int i = 0; i < S.length(); i++) {
            c[S.charAt(i) - 'a']++;
        }
        //当某个字母出现次数大于总长度一半时，说明一定会出现重复字段
        for (int length : c) {
            if (length > (S.length() + 1) / 2)
                return "";
        }
        //重写比较器，通过字母出现次数在大根堆排序
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return c[o2 - 'a'] - c[o1 - 'a'];
            }
        });
        //入堆
        for (int i = 0; i < 26; i++) {
            if (c[i] > 0)
                pq.add((char) (i + 'a'));
        }
        StringBuffer sb = new StringBuffer();
        //每次大根堆出前两个元素构串，之后这两个元素在c中的次数减一，然后把次数大于0的元素入堆
        //这样保证不会出现重复段
        while (!pq.isEmpty()) {
            Character a = pq.poll();
            Character b = pq.poll();
            if (a != null) {
                sb.append(a);
                --c[a - 'a'];
                if (c[a - 'a'] != 0) {
                    pq.add(a);
                }
            }
            if (b != null) {
                sb.append(b);
                --c[b - 'a'];
                if (c[b - 'a'] != 0) {
                    pq.add(b);
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        reorganizeString reorganizeString = new reorganizeString();
        System.out.println(reorganizeString.reorganizeString("a"));
    }
}
