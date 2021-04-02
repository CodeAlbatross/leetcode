package com.company.offer;

public class findNthDigit {
    /**
     * 剑指 Offer 44. 数字序列中某一位的数字
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * <p>
     * 请写一个函数，求任意第n位对应的数字。
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：n = 11
     * 输出：0
     *
     * @param n
     * @return 思路：
     * 数字范围    数量  位数    占多少位
     * 1-9        9      1       9
     * 10-99      90     2       180
     * 100-999    900    3       2700
     * 1000-9999  9000   4       36000  ...
     * <p>
     * 例如 2901 = 9 + 180 + 2700 + 12 即一定是4位数,第12位   n = 12;
     * 数据为 = 1000 + (12 - 1)/ 4  = 1000 + 2 = 1002
     * 定位1002中的位置 = (12 - 1) %  4 = 3    s.charAt(3) = 2;
     */
    public int findNthDigit(int n) {
        if (n == 0)
            return 0;
        int digit = 1;//占的位数1，2，3。。。
        long count = 9;//不同位数的数字占的总位数9，180，2700
        long start = 1;//不同位数数字的第一个数字1,10,1000,10000
        while (n > count) {
            n -= count;
            start *= 10;
            ++digit;
            count = digit * start * 9;
        }
        //从位长为digit的数字的第一个数字开始的第(n - 1)/digit个数字
        long num = start + (n - 1) / digit;
        //找到这个数字num的最终位数
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
