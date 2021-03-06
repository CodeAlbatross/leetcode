package com.company.normal;

import java.util.Arrays;

public class largestPerimeter {
    /**
     * 976. 三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * <p>
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[2,1,2]
     * 输出：5
     * 示例 2：
     * <p>
     * 输入：[1,2,1]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：[3,2,3,4]
     * 输出：10
     * 示例 4：
     * <p>
     * 输入：[3,6,2,3]
     * 输出：8
     *
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
