package com.company.normal;

/**
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 */
public class longestMountain {
    public int longestMountain(int[] A) {
        int length = 0, gradient = 0, max = 0, maxIndex = A.length;
        //首先排除以上升或不变趋势结束的情况，因为只上升不算山，结束下标前推
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] >= A[i - 1]) {
                maxIndex--;
            } else break;
        }
        for (int i = 0; i < maxIndex - 1; i++) {
            if (gradient == 0) {
                //一直上升则长度增加
                if (A[i + 1] > A[i]) {
                    length++;
                }
                //若遇到平顶，则从新计算长度
                if (length > 0 && A[i + 1] == A[i]) {
                    length = 0;
                    gradient = 0;
                }
                //遇到下坡则更新max，转去计算下坡长度
                if (length > 0 && A[i + 1] < A[i]) {
                    gradient = 1;
                    length++;
                    if (length > max) {
                        max = length;
                    }
                }
            }
            if (gradient == 1) {
                if (A[i + 1] < A[i]) {
                    length++;
                    if (length > max) {
                        max = length;
                    }
                } else {
                    //再次遇到上坡或平面，则长度清零，回去计算上坡
                    length = 0;
                    gradient = 0;
                    i--;
                }
            }
        }

        return max;
    }
}
