package com.company.byteDance;

import java.util.Arrays;

public class lengthOfLongestSubstring {
    /**
     *  无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
<<<<<<< HEAD
        int maxLength = 0;
        int length = 0;
        int[] indexes = new int[128];
        Arrays.fill(indexes,-1);
        for (int i = 0; i < s.length() ; i++){
            Character c = s.charAt(i);
            if (indexes[c] == -1){
                indexes[c] = i;
                length++;
                maxLength = Math.max(maxLength,length);
            }else{
                i = indexes[c];
                length = 0;
                Arrays.fill(indexes,-1);
            }
        }
        return maxLength;
    }
    public static void main(String ... args){
        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring("aaab"));
=======
        return 0;
>>>>>>> temp
    }
}
