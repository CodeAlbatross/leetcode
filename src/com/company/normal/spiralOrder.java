package com.company.normal;
/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return list;
        //确定边界
        int a = 0, b = 0, c = matrix.length - 1, d = matrix[0].length - 1;
        int length = (c + 1) * (d + 1);
        //螺旋遍历
        while (a <= c && b <= d) {
            for (int j = b; j <= d && list.size() < length; j++) {
                list.add(matrix[a][j]);
            }
            ++a;
            for (int j = a; j <= c && list.size() < length; j++) {
                list.add(matrix[j][d]);
            }
            --d;
            for (int j = d; j >= b && list.size() < length; j--) {
                list.add(matrix[c][j]);
            }
            --c;
            for (int j = c; j >= a && list.size() < length; j--) {
                list.add(matrix[j][b]);
            }
            ++b;
        }
        return list;
    }
}
