package com.company.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class deleteNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Integer[] nums = new Integer[n];
            Arrays.fill(nums, 0);
            List<Integer> l = new ArrayList<>(Arrays.asList(nums));
            int count = 2;
            int index = 0;
            while (l.contains(0)) {
                if (l.get(index) == 0)
                    --count;
                if (count == -1) {
                    if (l.get(index) == 0) {
                        l.set(index, 1);
                        count = 2;
                    }
                }
                index = (index + 1) % n;
            }
            System.out.println(index - 1);

        }


    }
}
