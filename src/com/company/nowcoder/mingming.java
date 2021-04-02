package com.company.nowcoder;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class mingming {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }
            for (Integer i : set){
                System.out.println(i);
            }
        }


    }
}
