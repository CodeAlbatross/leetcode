package com.company.offer;

import java.util.Arrays;

public class _61_isStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] > 0)
                return false;
            if (nums[i] == 0) {
                ++zeros;
            } else {
                while (zeros >= 0 && nums[i] + 1 < nums[i + 1]) {
                    --zeros;
                    if (zeros < 0)
                        return false;
                    nums[i]++;
                }
            }
        }
        return true;
    }
}
