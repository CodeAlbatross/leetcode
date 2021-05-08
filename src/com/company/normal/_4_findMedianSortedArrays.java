package com.company.normal;

public class _4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int odd = (n + m + 1) / 2;
        int even = (n + m + 2) / 2;
        return (func(nums1, 0, n - 1, nums2, 0, m - 1, odd) + func(nums1, 0, n - 1, nums2, 0, m - 1, even)) * 0.5;
    }

    private int func(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        int len1 = right1 - left1 + 1;
        int len2 = right2 - left2 + 1;

        if (len1 > len2) return func(nums2, left2, right2, nums1, left1, right1, k);
        if (len1 == 0) return nums2[left2 + k - 1];

        if (k == 1) return Math.min(nums1[left1], nums2[left2]);

        int i = left1 + Math.min(len1, k / 2) - 1;
        int j = left2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return func(nums1, left1, right1, nums2, j + 1, right2, k - (j - left2 + 1));
        }
        else {
            return func(nums1, i + 1, right1, nums2, left2, right2, k - (i - left1 + 1));
        }
    }

}
