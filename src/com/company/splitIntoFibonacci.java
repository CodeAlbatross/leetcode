package com.company;

import java.util.ArrayList;
import java.util.List;

public class splitIntoFibonacci {
    /**
     * 842. 将数组拆分成斐波那契序列
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     *
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     *
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     *
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     *
     * 示例 1：
     *
     * 输入："123456579"
     * 输出：[123,456,579]
     * 示例 2：
     *
     * 输入: "11235813"
     * 输出: [1,1,2,3,5,8,13]
     * 示例 3：
     *
     * 输入: "112358130"
     * 输出: []
     * 解释: 这项任务无法完成。
     * 示例 4：
     *
     * 输入："0123"
     * 输出：[]
     * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     * 示例 5：
     *
     * 输入: "1101111"
     * 输出: [110, 1, 111]
     * 解释: 输出 [11,0,11,11] 也同样被接受。
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backTrack(0,list,S);
        return list;
    }

    /**
     * 回溯法
     * @param index
     * @param list
     * @param S
     * @return
     */
    private boolean backTrack(int index, List<Integer> list, String S){
        //成功条件,list中有超过两个数，并且遍历完整个字符串
        if (index == S.length() && list.size() >=3){
            return true;
        }
        for (int i = index; i < S.length(); i++){
            //每个块的数字(两位数)不能以零开头
            if (S.charAt(index) == '0' && index < i){
                break;
            }
            int size = list.size();
            //截取字符串转数字
            long num = Long.parseLong(S.substring(index,i+1));
            //每个整数都符合 32 位有符号整数类型
            if (num > Integer.MAX_VALUE){
                break;
            }
            //如果list内容大于两个，如果截取的数字大于前两个数字之和，则说明后面的数都大于，于是退出
            if (size >= 2 && num > list.get(size-1) + list.get(size-2)){
                break;
            }
            //符合fib数列，加入列表
            if (size < 2 || num == list.get(size-1) + list.get(size-2)){
                list.add((int)num);
                //如果之后的数字都符合fib数列，返回true
                if (backTrack(i+1,list,S)){
                    return true;
                }
                //否则回溯
                list.remove(list.size()-1);
            }
        }
        return false;
    }
    public static void main(String... args){
        System.out.println(new splitIntoFibonacci().splitIntoFibonacci("0123"));
    }

}
