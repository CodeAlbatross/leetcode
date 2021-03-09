package com.company.normal;

import java.util.*;

public class medianSlidingWindow {
    /**
     * 480. 滑动窗口中位数
     * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
     *
     * 例如：
     *
     * [2,3,4]，中位数是 3
     * [2,3]，中位数是 (2 + 3) / 2 = 2.5
     * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     *
     *
     *
     * 示例：
     *
     * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
     *
     * 窗口位置                      中位数
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       1
     *  1 [3  -1  -3] 5  3  6  7      -1
     *  1  3 [-1  -3  5] 3  6  7      -1
     *  1  3  -1 [-3  5  3] 6  7       3
     *  1  3  -1  -3 [5  3  6] 7       5
     *  1  3  -1  -3  5 [3  6  7]      6
     *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
     *
     *  思路 双优先队列 + 延迟删除
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        double[] median = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++){
            dualHeap.insert(nums[i]);
        }
        median[0] = dualHeap.getMedian();
        for (int i = k; i < nums.length; i++){
            dualHeap.insert(nums[i]);
            dualHeap.erase(nums[i-k]);
            median[i - k + 1] = dualHeap.getMedian();
        }
        return median;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new medianSlidingWindow().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
class DualHeap{
    //双优先队列保存滑动窗口大的一半和小的一半
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    //<num,计数器>,相当于用一个计数器保存被删除的次数
    private Map<Integer,Integer> delayed;
    private int k;
    private int smallSize, largeSize;

    public DualHeap(int k){
        this.small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.large = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        this.k = k;
        this.delayed = new HashMap<Integer,Integer>();
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian(){
        if ((k & 1) == 1){
            return small.peek();
        }else
            return ((double)small.peek() + large.peek())/2;
    }

    public void makeBalance(){
        if (largeSize - smallSize == 1){
            small.offer(large.poll());
            --largeSize;
            ++smallSize;
            prune(large);
        }else if (smallSize - largeSize == 2){
            large.offer(small.poll());
            --smallSize;
            ++largeSize;
            prune(small);
        }
    }

    /**
     * 插入数字
     * @param num
     */
    public void insert(int num){
        if (small.isEmpty() || num <= small.peek()){
            small.offer(num);
            ++smallSize;
        }else{
            large.offer(num);
            ++largeSize;
        }
        makeBalance();
    }

    /**
     * 在堆中清除
     * @param num
     */
    public void erase(int num){
        //更新删除计数器
        delayed.put(num, delayed.getOrDefault(num,0) + 1);
        if (num <= small.peek()){
            --smallSize;
            if (num == small.peek())
                prune(small);
        }else if (large.peek() <= num){
            --largeSize;
            if (num == large.peek())
                prune(large);
        }
        makeBalance();

    }

    /**
     * 整理堆
     * 只有当数字位于堆顶的时候才删除(堆顶数字的删除计数器在hash表中存在),并且将被删除次数计数器-1,减少到0就将这个计数器在hash表中删除
     * @param heap
     */
    private void prune(PriorityQueue<Integer> heap){
        while (!heap.isEmpty()){
            //只有当数字位于堆顶的时候才删除(堆顶数字的删除计数器在hash表中存在),并且将被删除次数计数器-1,减少到0就将这个计数器在hash表中删除
            int num = heap.peek();
            if (delayed.containsKey(num)){
                delayed.put(num, delayed.get(num)-1);
                if (delayed.get(num) == 0){
                    delayed.remove(num);
                }
                heap.poll();
            }else {
                break;
            }
        }
    }

}
