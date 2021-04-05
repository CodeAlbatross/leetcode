package com.company.nowcoder;

import java.util.Scanner;

public class longestHuiWen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            int len = s.length();
            if (len < 3) {
                System.out.println(len);
                continue;
            }
            boolean[][] dp = new boolean[len + 1][len + 1];
            int maxLen = 1;
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    // 头尾字符不相等，不是回文串
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        // 相等的情况下
                        // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            // 状态转移
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                    // 此时更新记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;

                    }


                }
            }
            System.out.println(maxLen);
        }
    }
}
