package com.company.normal;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int count = 0;
        int rear = points[0][1];
        for (int[] point : points) {
            if (point[0] > rear) {
                ++count;
                rear = point[1];
            }
        }
        return count;
    }
}
