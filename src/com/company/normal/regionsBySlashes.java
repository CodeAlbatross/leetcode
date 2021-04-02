package com.company.normal;

public class regionsBySlashes {
    /**
     * 959. 由斜杠划分区域
     * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
     * <p>
     * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
     * <p>
     * 返回区域的数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [
     * " /",
     * "/ "
     * ]
     * 输出：2
     * <p>
     * 思路:把每个方格分成四份,将相连的格子加入并查集.
     * 两种情况:
     * 1. 格子由斜杠分割,两两相连,或者没有被斜杠分割,就是四个小格子相连
     * 2. 每个格子的下方和右方的小格子一定和右边格子的左边和上边小格子相连
     * 全部加入并查集之后,看有几个根节点就被分割成了几个区域
     *
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        count = 4 * n * n;
        UnionFind(count);
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                //偏移量
                int offset = 4 * (i * n + j);
                char c = row[j];
                //单元格内的合并
                switch (c) {
                    case '/' -> {
                        merge(offset, offset + 3);
                        merge(offset + 1, offset + 2);
                    }
                    case '\\' -> {
                        merge(offset, offset + 1);
                        merge(offset + 3, offset + 2);
                    }
                    default -> {
                        merge(offset, offset + 1);
                        merge(offset + 1, offset + 2);
                        merge(offset + 2, offset + 3);
                    }
                }
                //相邻单元格合并
                if (j + 1 < n) {
                    //合并右边
                    merge(offset + 1, offset + 4 + 3);
                }
                if (i + 1 < n) {
                    //合并下边
                    merge(offset + 2, offset + 4 * n);
                }
            }
        }

        return count;
    }


    /*------------------并查集--------------------------*/
    private int[] fa;
    private int[] rank;
    private int count;

    private void UnionFind(int n) {
        fa = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int x) {
        if (fa[x] == x) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    private void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (rank[x] <= rank[y]) {
            fa[x] = y;
        } else {
            fa[y] = x;
        }
        if (rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
        //只有根节点不相同的时候,合并计数才减一
        if (x != y)
            count--;
    }

    public static void main(String[] args) {
        System.out.println(new regionsBySlashes().regionsBySlashes(new String[]{"  /", "/ /", "\\/ "}));
    }
}
