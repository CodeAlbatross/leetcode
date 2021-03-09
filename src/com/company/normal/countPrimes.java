package com.company.normal;

import java.util.Arrays;

public class countPrimes {
    /**
     * 204. 计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 示例 2：
     *
     * 输入：n = 0
     * 输出：0
     * 示例 3：
     *
     * 输入：n = 1
     * 输出：0
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        int count = 0;
        for (int i = 2; i <= n; i++){
            if (isPrimes(i))
                ++count;
        }
        return count;
    }

    /**
     * 质数只能被1和它本身整除的正整数（它本身不能是1，最小的质数是2，2也是唯一的偶数质数）。
     * 存在除1和它本身外的因数的正整数是合数。判断一个数是否是质数时，只要试到它的平方根即可。
     * 一个合数分解质因数时，最大质因数不会大于它的平方根，所以循环从2到sqrt(n)即可。
     * @param n
     * @return
     */
    private boolean isPrimes(int n){
        if(n < 2){
            return false;
        }
        if (n != 2 && n != 3) {
            int a = (int) Math.sqrt(n);
            for (int i = 2; i <= a; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 方法二：埃氏筛
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int count = 0;
        int[] isPrime = new int[n];// isPrime[i] 表示数 i 是不是质数
        Arrays.fill(isPrime,1);
        for (int i = 2; i < n; i++){
            if (isPrime[i] == 1){
                ++count;
                if ((long)i * i < n){
                    //如果 x是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数
                    //对于一个质数 x，如果按上文说的我们从 2x 开始标记其实是冗余的，应该直接从 x⋅x 开始标记，
                    // 因为 2x,3x,… 这些数一定在 x 之前就被其他数的倍数标记过了
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }
}
