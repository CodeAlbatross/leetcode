package com.company.byteDance;

import java.util.Arrays;

/**
 *   字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length2 < length1)
            return false;
        int[] table1 = new int[26];
        int[] table2 = new int[26];
        for (int i = 0; i < length1; i++) {
            table1[s1.charAt(i) - 'a'] += 1;
            table2[s2.charAt(i) - 'a'] += 1;
        }
        for (int i = length1; i < length2; i++) {
            if (Arrays.equals(table1, table2)) {
                return true;
            }else {
                table2[s2.charAt(i - length1) - 'a'] -= 1;
                table2[s2.charAt(i) - 'a'] += 1;
            }
        }
        return Arrays.equals(table1, table2);
    }

    public static void main(String[] args) {
        System.out.println(new checkInclusion().checkInclusion("adc","dcda"));
    }
}
