package com.company.nowcoder;

public class Union {
    int[] rank;
    int[] fa;

    public Union(int n) {
        rank = new int[n];
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            fa[i] = i;
        }
    }

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    public void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (rank[fx] == rank[fy]) {
            fa[fx] = fy;
            ++rank[fy];
        } else if (rank[fx] > rank[fy]) {
            fa[fy] = fx;
        } else {
            fa[fx] = fy;
        }
    }
}
