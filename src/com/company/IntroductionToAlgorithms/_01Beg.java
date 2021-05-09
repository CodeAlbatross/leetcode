package com.company.IntroductionToAlgorithms;

import java.util.Scanner;

public class _01Beg {
    //动态规划
    public void func1(int n, int v, int[] weight, int[] value) {

        int[] f = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= weight[i]; j--) {
                f[j] = Math.max(f[j], f[j - weight[i]] + value[i]);
            }
        }
        System.out.println("动态规划，最大价值："+f[v]);

    }

    public int[] weight;
    public int[] value;
    int curWeight = 0;
    int curValue = 0;
    int bestValue = 0;
    int count;
    int maxWeight = 0;

    //回溯法
    public void func2(int n, int v, int[] weight, int[] value) {
        this.maxWeight = v;
        this.weight = weight;
        this.value = value;
        count = n;
        dfs(0);
        System.out.println("回溯法，最大的价值："+ bestValue);
    }
    public void dfs(int x){
        if (x == count){
            if (curValue > bestValue){
                bestValue = curValue;
            }
        }else {
            dfs(x+1);
            if (curWeight + weight[x] <= maxWeight){
                curWeight += weight[x];
                curValue += value[x];
                dfs(x+1);
                curWeight -= weight[x];
                curValue -= value[x];
            }
        }
    }

    public static void main(String[] args) {
        _01Beg beg = new _01Beg();
        beg.func1(5, 20, new int[]{0, 2, 3, 4, 5, 9}, new int[]{0, 3, 4, 5, 8, 10});
        beg.func2(5, 20, new int[]{2, 3, 4, 5, 9}, new int[]{3, 4, 5, 8, 10});
    }
}
