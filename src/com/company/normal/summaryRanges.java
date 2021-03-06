package com.company.normal;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    /**
     * 228. 汇总区间
     * 给定一个无重复元素的有序整数数组 nums 。
     * <p>
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     * <p>
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * <p>
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * 示例 2：
     * <p>
     * 输入：nums = [0,2,3,4,6,8,9]
     * 输出：["0","2->4","6","8->9"]
     * 解释：区间范围是：
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        int pre = nums[0];
        int length = 0;
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder(Integer.toString(pre));
        for (int i = 1; i < nums.length; i++) {
            length++;
            if (pre + 1 != nums[i]) {
                if (length != 1) {
                    s.append("->").append(pre);
                }
                list.add(new String(s));
                s = new StringBuilder(Integer.toString(nums[i]));
                length = 0;
            }
            pre = nums[i];
        }
        if (s.toString().equals(Integer.toString(pre))) {
            list.add(new String(s));
        } else {
            list.add(new String(s.append("->").append(Integer.toString(pre))));
        }
        return list;
    }
}
