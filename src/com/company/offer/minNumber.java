package com.company.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minNumber {
    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     * <p>
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *
     * @param nums
     * @return 此题求拼接起来的 “最小数字” ，本质上是一个排序问题。
     * 排序判断规则： 设 nums 任意两数字的字符串格式 x 和 y ，则
     * 若拼接字符串 x + y > y + x ，则 m > n ；
     * 反之，若 x + y < y + x ，则 n < m ；
     * 根据以上规则，套用任何排序方法对 nums 执行排序即可。
     */
    public String minNumber(int[] nums) {
        List<String> num = new ArrayList<>();
        for (int n : nums) {
            //num.add(Integer.toString(n));
            num.add(String.valueOf(n));
        }
        /*
            传递规则证明
            字符串 xy < yx , yz < zy ，需证明 xz < zx 一定成立。

            设十进制数 x, y, z 分别有 a, b, c 位，则有：
            （左边是字符串拼接，右边是十进制数计算，两者等价）
            xy = x * 10^b + y
            yx = y * 10^a + x

            则 xy < yx 可转化为：
            x * 10^b + y < y * 10^a + x
            x (10^b - 1) < y (10^a - 1)
            x / (10^a - 1) < y / (10^b - 1)     ①

            同理， 可将 yz < zy 转化为：
            y / (10^b - 1) < z / (10^c - 1)     ②

            将 ① ② 合并，整理得：
            x / (10^a - 1) < y / (10^b - 1) < z / (10^c - 1)
            x / (10^a - 1) < z / (10^c - 1)
            x (10^c - 1) < z (10^a - 1)
            x * 10^c + z < z * 10^a + x
            ∴  可推出 xz < zx ，传递性证毕
         */
        num.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        /*StringBuffer stringBuffer = new StringBuffer();
        for (String s : num){
            stringBuffer.append(s);
        }
        return stringBuffer.toString();*/
        return String.join("", num);
    }
}
