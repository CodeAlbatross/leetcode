package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge {
    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     *
     *
     * 示例 1:
     *
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: intervals = [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        for (int i = 0; i < intervals.length-1; i++){
            int[] a = intervals[i];
            int[] b = intervals[i+1];
            if (a[1] < b[0]){
                list.add(a[1]);
                lists.add(new ArrayList<>(list));
                list.clear();
                list.add(b[0]);
            }
            if (a[1] > b[1]){
                intervals[i+1][1] = a[1];
            }
        }
        list.add(intervals[intervals.length-1][intervals[0].length-1]);
        lists.add(new ArrayList<>(list));
        int[][] merge = new int[lists.size()][2];
        for (int i = 0; i < merge.length; i++){
            for (int j = 0 ; j < merge[0].length; j ++){
                merge[i][j] = lists.get(i).get(j);
            }
        }
        return merge;
    }
}
