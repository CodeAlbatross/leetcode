package com.company.Dp;

public class _5_longestPalindrome {
    public static String longestPalindrome(String s) {

        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        int start = 0, maxl = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j-i+1 > maxl){
                    maxl = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxl);
    }
}
