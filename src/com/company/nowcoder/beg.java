package com.company.nowcoder;

import java.util.Scanner;

/**
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 * 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j1] * w[j1] + v[j2] * w[j2 ]+ … +v[jk ]*w[jk ] 。（其中 * 为乘号）
 * 请你帮助王强设计一个满足要求的购物单。
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * <p>
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * <p>
 * <p>
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * <p>
 * <p>
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * <p>
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * 示例1
 * 输入
 * 复制
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 * 输出
 * 复制
 * 2200
 */
public class beg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            int money = in.nextInt()/10;
            int m = in.nextInt();
            good[] goods = new good[m + 1];
            for (int i = 1; i < m+1; i++) {
                int v = in.nextInt()/10;
                int p = in.nextInt();
                int q = in.nextInt();
                goods[i] = new good(v, p, q);
                if (q > 0){
                    //如果主键的附件1为空则设为附件1
                    if (goods[q].a1 == 0){
                        goods[q].setA1(i);
                    }else {
                        //主键已经有附件1了，设为附件2
                        goods[q].setA2(i);
                    }
                }
            }

            int[][] dp = new int[m+1][money+1];
            for (int i = 1; i < m + 1; i++) {
                int v = 0, v1 = 0, v2 = 0, v3 = 0;//钱
                int temp = 0,temp1 = 0, temp2 = 0, temp3 = 0;//价值
                //只买主件
                v = goods[i].v;
                temp = goods[i].p * v;

                //主件和附件1
                if (goods[i].a1 != 0){
                    v1 = v + goods[goods[i].a1].v;
                    temp1 = temp + goods[goods[i].a1].v * goods[goods[i].a1].p;
                }

                //主件和附件2
                if (goods[i].a2 != 0){
                    v2 = v + goods[goods[i].a2].v;
                    temp2 = temp + goods[goods[i].a2].v * goods[goods[i].a2].p;
                }
                //主件和附件1，2
                if (goods[i].a2 != 0 && goods[i].a1 != 0){
                    v3 = v + goods[goods[i].a2].v + goods[goods[i].a1].v;
                    temp3 = temp + goods[goods[i].a2].v * goods[goods[i].a2].p + goods[goods[i].a1].v * goods[goods[i].a1].p;
                }

                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i-1][j];
                    if (goods[i].q == 0){
                        //这里判断v！= 0是为了节省时间
                        if (j >= v && v!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v] + temp);
                        if (j >= v1 && v1!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v1] + temp1);
                        if (j >= v2 && v2!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v2] + temp2);
                        if (j >= v3 && v3!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v3] + temp3);
                    }
                }

            }
        System.out.println(dp[m][money]*10);
    }


    private static class good {
        public int v;//价格
        public int p;//重要度
        public int q;//主件附件ID

        public int a1 = 0;//附件1ID
        public int a2 = 0;//附件2ID

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
