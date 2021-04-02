package com.company.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class score {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
        int m = in.nextInt();
        int n = in.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i < m+1; i++) {
            map.put(i, in.nextInt());
        }
        for (int j = 0; j < n; j++) {

            char x = in.next().charAt(0);

            int l1 = Integer.parseInt(in.next());
            int l2 = Integer.parseInt(in.next());
            if (x =='Q'){
                int max = 0;
                if (l1 < l2) {
                    for (Integer i : map.keySet()) {
                        if (i <= l2 && i >= l1) {
                            max = Math.max(max, map.get(i));
                        }
                    }
                }else {
                    for (Integer i : map.keySet()) {
                        if (i <= l1 && i >= l2) {
                            max = Math.max(max, map.get(i));
                        }
                    }
                }
                System.out.println(max);
            }else if (x=='U'){
                map.put(l1,l2);
            }
        }

    }
    }
}
