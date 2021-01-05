package com.company;

public class rotate {
    /**
     * 48. 旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 示例 2:
     *
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     * @param matrix
     *
     * 从最外圈开始，每次交换四个角的元素，直到最内圈
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n;
        for (int x = 0; x < n/2; ++x){
            for (int y = x; y < m - 1; ++y){
                exchange(matrix,x,y);
            }
            m -= 2;
        }
    }

    /**
     * 交换矩阵的四个元素
     * @param matrix
     * @param x
     * @param y
     */
    private void exchange(int[][] matrix, int x, int y){
        int m = matrix.length;
        int temp1 = matrix[y][m-x-1];
        matrix[y][m-x-1] = matrix[x][y];

        int temp2 = matrix[m-x-1][m-y-1];
        matrix[m-x-1][m-y-1] = temp1;

        int temp3 = matrix[m-y-1][x];
        matrix[m-y-1][x] = temp2;

        matrix[x][y] = temp3;
    }
    public static void main(String... args){
        new rotate().rotate(new int[][]{{1,2},{3,4}});
    }
}
