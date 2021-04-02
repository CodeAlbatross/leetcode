package com.company.begNineLessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class the_groupingBegProblem {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//共有n组
        int v = in.nextInt();
        int[] f = new int[v+1];
        /*
        for (所有的组k)
            for (int j = V; j >= 0; j--)
                for (所有属于组k的i)
                    f[j] = max{f[j], f[j - w[i]] + v[i]}
         */
        for (int i = 1; i <= n; i++) {
            int num = in.nextInt();
            int[] vi = new int[num+1];
            int[] wi = new int[num+1];
            for (int j = 1; j <= num; j++) {
                vi[j] = in.nextInt();
                wi[j] = in.nextInt();
            }
            /*
            错误示范
            for(j...0)这一层循环必须在for(所有的i属于组k)之外。
            这样才能保证每一组内的物品最多只有一个会被添加到背包中。
            for (int j = 1; j <=num ; j++) {
                for (int k = v; k >= vi[j] ; k--) {
                    f[k] = Math.max(f[k], f[k-vi[j]]+wi[j]);
                }
            }
             */
            for (int j = v; j >= 0 ; j--) {
                for (int k = 1; k <= num ; k++) {
                    if (j >= vi[k]) f[j] = Math.max(f[j], f[j-vi[k]]+wi[k]);
                }
            }
        }
        System.out.println(f[v]);
    }
}



