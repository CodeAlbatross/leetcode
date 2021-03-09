package com.company.normal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int j : arr) {
            ++count[j + 1000];
        }

        Set<Integer> set = new HashSet<>();
        for (int j : count) {
            if (set.contains(j)) {
                return false;
            } else if (j != 0) {
                set.add(j);
            }
        }
        return true;
    }
}
