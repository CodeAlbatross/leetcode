package com.company.offer;

/**
 * 本题说的将绳子剪成m段，m是大于1的任意一个正整数，也就是必须剪这个绳子，至于剪成几段，每一段多长，才能使得乘积最大
 */
public class cuttingRope2 {
    /**
     * 数论
     * 数学证明：定义函数 f(x) 表示将给定的正整数 n 拆分成尽可能多的正数 x 的情况下的最大乘积，则可以将 n 分成 \frac{n}{x}
     * x
     * n
     *   项，此时 f(x)=x^{\frac{n}{x}}f(x)=x
     * x
     * n
     *  ，通过求导可得f(x)在x=e时取最大值，f(3)>f(2)，x=3 时，可以得到最大乘积。
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 3)
            return n-1;
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0){
            return (int)pow(3,quotient);
        }else if (remainder == 2){
            return (int)((pow(3,quotient) * 2)%1000000007);
        }else {
            return (int)((pow(3,quotient-1) * 4)%1000000007);
        }
    }

    /**
     * 快速求幂
     * @param base
     * @param power
     * @return
     */

    private long pow(long base, int power){

        if(power == 0)
            return 1;
        long product = 1;
        while (power > 0){
            if ((power & 1) == 1){//等于power%2 == 1
                product = (product * base) % 1000000007;
            }
            power >>= 1;//等于power/2
            base = (base * base)%1000000007;
        }
        return product;
    }

}

