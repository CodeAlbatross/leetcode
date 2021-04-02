package com.company.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _40_getLeastNumbers {
    /**
     * 剑指 Offer 40. 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * @param arr-数组
     * @param k-
     * @return -
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> bigHeap = new PriorityQueue<>((a, b) -> b - a);//默认小顶堆,切换到大顶堆
        for (int num : arr) {
            if (bigHeap.size() < k) {
                bigHeap.offer(num);
            } else if (num < bigHeap.peek()) {
                bigHeap.poll();
                bigHeap.offer(num);
            }
        }
        int[] res = new int[bigHeap.size()];
        int i = 0;
        while (!bigHeap.isEmpty()) {
            res[i++] = bigHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _40_getLeastNumbers().getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0)));
    }
}
