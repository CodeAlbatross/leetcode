package com.company.Dp;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 *
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 *
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 */
public class _97_isInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length() ,l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        //动态规划
        //dp[i][j]表示s1的前i个字母可以和s2的前j个字母组成上s3的前i+j个字母
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int i = 1; i <= l1 && s3.charAt(i-1) == s1.charAt(i-1); i++) dp[i][0] = true;
        for (int i = 1; i <= l2 && s3.charAt(i-1) == s2.charAt(i-1); i++) dp[0][i] = true;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                //这里可以理解成62题的不同路径,每次只能从dp[i-1][j]或者dp[i][j-1]转移来,前一步可以组成则这一步再判断能不能成立
                dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) ||
                        (dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("db","b","cbb"));
    }
}
