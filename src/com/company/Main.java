package com.company;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i = m; i <= n; i++) {
                if (is(i))
                    list.add(i);
            }
            if (list.size() == 0)
                System.out.println("no");
            for (int num : list){
                System.out.print(num+"");
            }
            System.out.println();
        }
    }
    public static boolean is(int num){
        int sum = 0;
        int tem = num;
        for (int i = 0; i < 3; i++) {
            int index = num % 10;
            sum += index*index*index;
            num -= index;
            num /= 10;
        }
        return sum == tem;
    }
}