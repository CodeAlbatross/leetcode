package com.company;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class isPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        if (s.length() == 1)
            return true;
        int a = 0, b = s.length()-1;
        while (a <= b){
            while (a < s.length()-1 && !isLetter(s.charAt(a))){
                a++;
            }
            while (b > 0  && !isLetter(s.charAt(b))){
                b--;
            }
            if (a < s.length()-1 && b > 0 && s.charAt(a) != s.charAt(b) && Math.abs(s.charAt(a)-s.charAt(b)) != 32){
                return false;
            }else {
                a++;
                b--;
            }

        }
        return true;
    }
    public static boolean isLetter(Character s1){
        return  ((s1 >= 'A' && s1 <= 'Z') || (s1 >= 'a' && s1 <= 'z') || (s1 >= '0' && s1 <= '9'));
    }
}
