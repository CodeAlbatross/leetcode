package com.company.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class allCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] distance = new int[R*C][2];
        int index = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                distance[index++] = new int[]{i,j};
            }
        }
        Arrays.sort(distance, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0)) - (Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0));
            }
        });
        return distance;
    }
}
