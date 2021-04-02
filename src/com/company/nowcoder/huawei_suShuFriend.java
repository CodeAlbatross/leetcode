package com.company.nowcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 主要思想是匈牙利算法
 */
public class huawei_suShuFriend {
    static List<Integer> odd;
    static List<Integer> even;
    //static boolean[][] line;
    static boolean[] used;
    static int[] evenMatch;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int l = in.nextInt();
            odd = new LinkedList<>();
            even = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                int num = in.nextInt();
                if ((num & 1) == 1){
                    odd.add(num);
                }else {
                    even.add(num);
                }
            }
            int m = odd.size();
            int n = even.size();
            //用于标记那个奇数匹配了偶数,直接记录奇数的值，而不是奇数在奇数数组中的下标
            evenMatch = new int[n];
            used = new boolean[n];

            int all=0;
            //依次遍历奇数，去匹配偶数
            for (Integer integer : odd) {
                used = new boolean[n];
                if (find(integer))
                    all++;
            }
            System.out.println(all);
        }
    }
    public static boolean find(int x){
        int i,j;
        for (j=0;j<even.size();j++){    //扫描每个偶数
            if (couldLine(x+even.get(j)) && !used[j])
            //如果可以成对并且还没有标记过(这里标记的意思是这次查找曾试图改变过该偶数的归属问题，但是没有成功，所以就不用瞎费工夫了）
            {
                used[j]=true;
                if (evenMatch[j]==0 || find(evenMatch[j])) {
                    //名花无主或者能腾出个位置来，这里使用递归
                    evenMatch[j]=x;
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 是一对素数
     */
    public static boolean couldLine(int num){
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
