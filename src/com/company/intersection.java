package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1){
            set.add(num);
        }
        for (int num : nums2){
            set2.add(num);
        }
        set.retainAll(set2);
        int[] num = new int[set.size()];
        int i = 0;
        for (int s : set){
            num[i++] = s;
        }
        return num;
    }
}
