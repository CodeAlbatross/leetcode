package com.company.normal;

public class searchRange {
    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[]{-1, -1};
        int begin = 0;
        int end = nums.length - 1;
        int mid;
        while (begin >= 0 && end < nums.length && begin < end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                indexes[0] = mid;
                indexes[1] = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        while (indexes[0] >= 0 && nums[indexes[0]] == target) {
            if (indexes[0] - 1 >= 0 && nums[indexes[0] - 1] == target) {
                --indexes[0];
            } else break;
        }
        while (indexes[1] >= 0 && nums[indexes[1]] == target) {
            if (indexes[1] + 1 < nums.length && nums[indexes[1] + 1] == target) {
                ++indexes[1];
            } else break;
        }
        return indexes;
    }
}
