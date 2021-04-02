package com.company.normal;

public class findMaxAverage {
    /**
     * 643. 子数组最大平均数 I
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：[1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * <p>
     * 思路:延续前一题的思路,有些繁琐
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        findSum findSum = new findSum(k);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            findSum.insert(nums[i]);
        }
        max = Math.max(findSum.getSum(), max);
        int length = nums.length;
        for (int i = k; i < length; i++) {
            findSum.insert(nums[i]);
            max = Math.max(findSum.getSum(), max);
        }
        return 1.0 * max / k;
    }

    public static void main(String[] args) {
        System.out.println(new findMaxAverage().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }


}

class findSum {
    final int k;
    final int[] nums;
    static int count = 0;
    private int sum = 0;

    public findSum(int k) {
        this.k = k;
        this.nums = new int[k];
    }

    public void insert(int num) {
        sum -= nums[count % k];
        nums[count++ % k] = num;
        sum += num;
    }

    public int getSum() {
        return sum;
    }
}