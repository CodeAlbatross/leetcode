package com.company.nowcoder;

import java.util.PriorityQueue;
import java.util.Scanner;

public class smallestNNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
            for (int i = 0; i < n; i++) {
                pq.add(in.nextInt());
            }
            for (int i = 0; i < k; i++) {
                if(i==(k-1))
                    System.out.println(pq.poll());//这个必须是换行 不然过不了 同理必须不空格！
                else
                    System.out.print(pq.poll()+" ");
            }
        }
    }
}
