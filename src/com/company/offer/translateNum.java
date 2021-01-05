package com.company.offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class translateNum {
    private int ret = 0;
    public int translateNum(int num) {
        String ns =  String.valueOf(num);
        dfs(ns,0);
        return ret;
    }
    private void dfs(String ns, int index){
        if (index >= ns.length())
            return;
        if (index == ns.length()-1) {
            ret++;
            return;
        }
        int i = Integer.parseInt(ns.substring(index, index + 2));
        if (i <= 25 && i >9){
            if (index+2 == ns.length()){
                ret++;
            }
            dfs(ns,index+2);
        }
        dfs(ns,index+1);

    }
    public static void main(String... args){
        System.out.println(new translateNum().translateNum(2147483647));
    }
}
