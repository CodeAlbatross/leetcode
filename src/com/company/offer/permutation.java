package com.company.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class permutation {
    List<String> list = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }
    private void dfs(int x){
        if (x == c.length -1){
            list.add(String.valueOf(c));
            return;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = x; i < c.length; i++){
            if (hashSet.contains(c[i]))
                continue;
            hashSet.add(c[i]);
            //在每一层交换这个元素和他后面的每一个元素
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }
    private void swap(int a, int b){
        char temp  =c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
