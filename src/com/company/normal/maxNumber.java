package com.company.normal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class maxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int start = Math.max(0, k - n), end = Math.min(k, m);
        int[] max = new int[k];
        for (int i = start; i <= end; i++){
            int[] A = pickMax(nums1,i);
            int[] B = pickMax(nums2,k-i);
            int[] C = merge(A,B);
            max = compare(max,C);
        }
        return max;
    }
    /**
     * 选出m长度的最长字符串
     * @param num
     * @param m
     * @return
     */
    public int[] pickMax(int[] num, int m){
        int k = num.length-m;//选择m个值，意味着删除k个值
        Deque<Integer> deque = new LinkedList<>();
        for (int c : num) {
            while (!deque.isEmpty() && k > 0 && c > deque.peekLast()) {
                deque.pollLast();//出队
                --k;
            }
            deque.addLast(c);//入队
        }
        int[] pickedNums = new int[m];
        int index = 0;
        int keep = deque.size()-k;//如果k没有删除完，则相当于保留没有删除完部分的前keep位
        while(!deque.isEmpty() && keep > 0){
            int c = deque.pollFirst();
            if(c != '0' || index !=0 ){
                pickedNums[index++] = c;
                --keep;
            }
        }
        return pickedNums;
    }

    /**
     * 合并两个字符串返回最大值
     * @param subsequence1
     * @param subsequence2
     * @return
     */
    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            //如果两个当前元素不同，则选其中较大的元素作为下一个合并的元素，
            //否则需要比较后面的所有元素才能决定选哪个元素（之后哪个元素大选择哪个）作为下一个合并的元素
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        //x长返回正，y长返回负
        return (x - index1) - (y - index2);
    }

    /**
     * 简单比较两个字符串大小
     * @param A
     * @param B
     * @return
     */
    public int[] compare(int[] A, int[] B){
        for (int i = 0 ; i < A.length; i++){
            if (A[i] > B[i]){
                return A;
            }else if (A[i] < B[i]){
                return B;
            }
        }
        return A;
    }

    public static void main(String... args){
        System.out.println(Arrays.toString(new maxNumber().maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5)));
    }
}
