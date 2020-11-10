package com.company;

import java.util.*;

public class kClosest {
    /**
     * 973. 最接近原点的 K 个点
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     *
     * （这里，平面上两点之间的距离是欧几里德距离。）
     *
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     *
     *
     *
     * 示例 1：
     *
     * 输入：points = [[1,3],[-2,2]], K = 1
     * 输出：[[-2,2]]
     * 解释：
     * (1, 3) 和原点之间的距离为 sqrt(10)，
     * (-2, 2) 和原点之间的距离为 sqrt(8)，
     * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
     * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
     * 示例 2：
     *
     * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
     * 输出：[[3,3],[-2,4]]
     * （答案 [[-2,4],[3,3]] 也会被接受。）
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points.length<=1)
            return points;
        Map<int[], Double> map = new HashMap<>();
        for (int[] point : points){
            map.put(point, Math.sqrt(point[0]*point[0]+point[1]*point[1]));
        }
        List<Map.Entry<int[], Double>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));//逆序排列map
        int[][] ints = new int[K][];
        for (int i = 0; i < K ; i++){
            ints[i] = mapList.get(i).getKey();
        }
        return ints;
    }
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        //拷贝一个数组的0-k项
        return Arrays.copyOfRange(points, 0, K);
    }

    /**
     * 快速排序思想
     * @param points
     * @param K
     * @return
     */
    Random rand = new Random();
    public int[][] kClosest3(int[][] points, int K) {
        int n = points.length;
        randomSelect(points,0 , n-1,K);
        return Arrays.copyOfRange(points, 0, K);
    }
    private void randomSelect(int[][] points,int left,int right, int K){
        //随机选一个范围内的数当作快排分割点
        int pivotId = left + rand.nextInt(right-left+1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        //先把最右边暂时储存分割点
        swap(points,right,pivotId);
        int i = left - 1;
        for (int j = left; j < right; j++){
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            //从左到右，把小于分割点的都放在分割点右边
            if (dist <= pivot){
                ++i;
                swap(points,i,j);
            }
        }
        ++i;
        //把最右边的暂存的分割点换回来 i
        swap(points,i,right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1){
            randomSelect(points,left,i-1,K);
        }else if (K > i - left + 1){
            randomSelect(points,i+1,right,K - (i - left +1));
        }

    }
    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

}
