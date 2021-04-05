package com.company.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

public class huawei_group {
    /**
     * 先把三和五的倍数都挑出来，算好两边的和sum3和sum5，所有数总和为sum，
     * 求出target = sum/2 - sum3，把剩余的数放在一起，
     * 转化成在一个list中找能不能凑出target。
     * 如果能剩下的一部分数可以凑出一个target，那另外一部分一定可以凑出剩下的一个target
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            LinkedList<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            int sum5 = 0;
            int sum3 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();
                if (cur % 5 == 0){
                    sum5 += cur;
                }else if (cur % 3 == 0){
                    sum3 += cur;
                }else{
                    list.add(cur);
                }
                sum += cur;
            }
            //如果能剩下的一部分数可以凑出一个target，那另外一部分一定可以凑出剩下的一个target2
            int target = sum/2 - sum5;
            int target2 = sum/2 - sum3;
            if (sum % 2 != 0) System.out.println("false");
            else System.out.println(helper(list, target));
        }
    }
    private static boolean helper(LinkedList<Integer> list, int target){
        return helper(0, list, target);
    }
    private static boolean helper(int l, LinkedList<Integer> list, int target){
        if (l == list.size()) return target == 0;
        //递归，当前数加入不加入凑数
        return helper(l + 1, list, target - list.get(l)) || helper(l + 1, list, target);
    }
}
