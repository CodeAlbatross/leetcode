package com.company.Dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 *
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。
 */
public class _467_findSubstringInWraproundString {
    public static int findSubstringInWraproundString(String p) {
        p = '^'+p;//优化边界条件
        int ans = 0;
        int pre = 1;
        int len = p.length();
        char c = p.charAt(0);
        Map<Character,Integer> map = new HashMap<>();//保存以x字母结尾的最长字符串长度,这个长度就是以这个字母结尾的子串的个数(参考最大前缀和)
        for (int i = 1; i < len; i++) {
            if (c == p.charAt(i)-1 || c - p.charAt(i) == 25){
                pre++;
            }else {
                pre = 1;
            }
            c = p.charAt(i);
            map.put(p.charAt(i),Math.max(map.getOrDefault(p.charAt(i),pre),pre));
        }
        for (int i : map.values())
            ans+=i;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("erflokatkn"));
    }
}
