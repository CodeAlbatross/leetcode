package com.company.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class _131_partition {
    /**
     * 回溯法 + dp优化
     * 用f(i,j)表示第i-j是回文串
     * @param s
     * @return
     */
    List<List<String>> answers = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],true);
        }
        //dp预处理，用f(i,j)表示第i-j是回文串
        //用一个n*n的二维数组来表示i-j是否为回文串
        //dp[i][j] =  (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
        for (int i = n-2; i >= 0; --i) {
            for (int j = i+1; j < n; ++j) {
                dp[i][j] =  (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1               ];
            }
        }
        dfs(s,0);
        return answers;
    }
    private void dfs(String s,int i){
        if (n == i){
            answers.add(new ArrayList<>(ans));
            return;
        }
        //每次从新的i开始处理之后的字符串
        for (int j = i; j < n; j++) {
            if (dp[i][j]){
                //如果第i..j是回文串，就把它加入到ans中
                ans.add(s.substring(i,j+1));
                //之后从j+1开始，递归检查后面的字符串
                dfs(s, j+1);
                //回溯，把刚才加入的回文串取出
                //相当于再次检查取出的这段回文串是否能在分割成多个回文串
                ans.remove(ans.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new _131_partition().partition("ababababababababababababcbabababababababababababa"));
    }
}
