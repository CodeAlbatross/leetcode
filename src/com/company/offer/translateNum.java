package com.company.offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class translateNum {
    private int ret = 0;

    public int translateNum(int num) {
        String ns = String.valueOf(num);
        dfs(ns, 0);
        return ret;
    }

    private void dfs(String ns, int index) {
        //越界返回
        if (index >= ns.length())
            return;
        //翻译完成
        if (index == ns.length() - 1) {
            ret++;
            return;
        }
        //截取从index开始的两位
        int i = Integer.parseInt(ns.substring(index, index + 2));
        //情况1，这两位是十位数
        if (i <= 25 && i > 9) {
            if (index + 2 == ns.length()) {
                //是最后的两位，则翻译完成
                ret++;
            }
            //否则从两位后的那一位开始继续递归
            dfs(ns, index + 2);
        }
        //情况2，这两位是一位数02，03...;或者大于25取不到翻译
        dfs(ns, index + 1);

    }

    public static void main(String... args) {
        System.out.println(new translateNum().translateNum(2147483647));
    }
}
