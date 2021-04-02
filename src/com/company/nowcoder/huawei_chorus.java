package com.company.nowcoder;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 华为机试 合唱队
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 * 注意不允许改变队列元素的先后顺序
 * 请注意处理多组输入输出！
 *
 * 输入描述:
 * 整数N
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入
 * 复制
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 复制
 * 4
 */
public class huawei_chorus {
    //两次dp，从前向后从后向前分别求出最长递增子序列
    //dp保存的是i在最长递增子序列中的位置
    //两个dp相加中最大的数就是完整最长队列中间位置（因为左边递增长度+右边递减长度最大）
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] dp1 = new int[n];
            int[] dp2 = new int[n];
            Arrays.fill(dp1,1);
            Arrays.fill(dp2,1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]){
                        dp1[i] = Math.max(dp1[i],dp1[j]+1);
                    }
                }
            }
            int max = 0;
            for (int i = n-2; i > 0; i--) {
                for (int j = n-1; j > i; j--) {
                    if (nums[i] > nums[j]){
                        dp2[i] = Math.max(dp2[i],dp2[j]+1);
                    }
                }
                dp1[i] += dp2[i];
                max = Math.max(dp1[i], max);
            }
            System.out.println(n-max+1);
        }
    }
}
