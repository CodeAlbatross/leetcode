package com.company.offer;

import java.util.ArrayList;
import java.util.List;

public class findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[10000];
        for (int num : nums){
            if (hash[num] == 0){
                hash[num] = 1;
            }else return num;
        }
        return 0;
    }
}
