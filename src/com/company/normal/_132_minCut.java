package com.company.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 */
public class _132_minCut {


    public int minCut(String s) {
        int len = s.length();
        //dp预处理所有回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        //再次dp处理，第i个回文串的分割次数都是第i-1个回文串次数+1
        //f[i]表示0-i个字符串最小分割次数

        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                //[0~i]不是一个回文串
                //循环遍历[0~i）中最小分割次数
                for (int j = 0; j < i; j++) {
                    //如果j+1~i是回文串，则f[i] = f[j]+1;
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _132_minCut().minCut("ab"));
    }
}
