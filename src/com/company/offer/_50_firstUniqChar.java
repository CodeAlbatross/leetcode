package com.company.offer;

import java.util.ArrayList;
import java.util.List;

public class _50_firstUniqChar {
    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <p>
     * 示例:
     * <p>
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (counts[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new _50_firstUniqChar().firstUniqChar("leetcode"));
    }
}
