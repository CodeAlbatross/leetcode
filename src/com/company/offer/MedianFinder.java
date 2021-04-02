package com.company.offer;


import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    /**
     * 剑指 Offer 41. 数据流中的中位数
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * <p>
     * 例如，
     * <p>
     * [2,3,4] 的中位数是 3
     * <p>
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     * <p>
     * 设计一个支持以下两种操作的数据结构：
     * <p>
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例 1：
     * <p>
     * 输入：
     * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
     * [[],[1],[2],[],[3],[]]
     * 输出：[null,null,null,1.50000,null,2.00000]
     * 示例 2：
     * <p>
     * 输入：
     * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
     * [[],[2],[],[3],[]]
     * 输出：[null,null,2.00000,null,2.50000]
     */
    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>();//小顶堆。保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x));//大顶堆。保存较小的一半

    }

    public void addNum(int num) {
        //两种添加方式，这里是一种
        //保持A的大小永远等于或大于B的大小一个

        if (A.size() == B.size()) {
            //所以当AB大小相等时向A添加
            B.add(num);
            A.add(B.poll());
        } else {
            //A比B大小大一时向B添加

            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        //这样当取中位数时，当总数为奇数时，中位数就会在A的堆顶
        if (A.size() != B.size()) {
            return A.peek();
        } else {
            return (A.peek() + B.peek()) >> 1;
        }

    }
}


