package com.company.offer;

public class myPow {
    public double myPow(double x, int n) {
        if(n >= 0) {
            return myPowPositive(x, n);
        }else{
            return 1.0/myPowPositive(x,n);
        }

    }

    private double myPowPositive(double x, long n) {
        if (n == 0)
            return 1;
        //注意这里n如果等于int最小值，-n就不再是绝对值
        if (n < 0)
            n = -n;
        double result = 1;
        while (n > 0){
            if ((n & 1) == 1){
                result = result * x;
                --n;
            }
            n >>= 1;
            x =  x * x;
        }
        return result;
    }
}
