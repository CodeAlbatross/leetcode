package com.company.offer;

public class _53_search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int count = 0;
        int index = midSearch(nums, target, 0, len - 1);
        int temp = index - 1;
        while (temp >= 0 && nums[temp] == target) {
            ++count;
            --temp;
        }
        while (index < len && nums[index] == target) {
            ++count;
            ++index;
        }
        return count;
    }

    private int midSearch(int[] nums, int target, int left, int right) {
        if (left > right)
            return 0;
        int mid = left + (right - left) / 2;
        if (nums[mid] > target) {
            return midSearch(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return midSearch(nums, target, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _53_search().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
