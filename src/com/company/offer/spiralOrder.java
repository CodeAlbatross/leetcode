package com.company.offer;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int a = 0, b = 0, c = matrix.length-1, d = matrix[0].length-1;
        int i = 0;
        int[] nums = new int[(c+1)*(d+1)];
        while (a <= c && b <= d){
            for (int j = b; j <= d && i < nums.length ; j++, i++){
                nums[i] = matrix[a][j];
            }
            ++a;
            for (int j = a; j <= c&& i < nums.length; j++, i++){
                nums[i] = matrix[j][d];
            }
            --d;
            for (int j = d; j >= b&& i < nums.length; j--, i++){
                nums[i] = matrix[c][j];
            }
            --c;
            for (int j = c; j >= a&& i < nums.length; j--, i++){
                nums[i] = matrix[j][b];
            }
            ++b;
        }
        return nums;
    }
}
