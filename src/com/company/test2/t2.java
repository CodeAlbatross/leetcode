package com.company.test2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 掌握与密码学相关的基础数论知识；
 * 利用中间相遇攻击来编程实现离散对数的求解。
 * x = 1~2^40
 * B = 2^20
 * 等式：h*g^(x1)=(g^B)^x0 | x0,x1包含于[0,B-1],B=2^20
 * 枚举每一个左边等式的可能性,加入hash表
 * 然后枚举右边等式的可能性,如果存在与hash表中,就找到
 *
 */
public class t2 {
    public static void main(String[] args) {
        String sp = "13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084171";
        String sg = "11717829880366207009516117596335367088558084999998952205599979459063929499736583746670572176471460312928594829675428279466566527115212748467589894601965568";
        String sh = "3239475104050450443565264378728065788649097520952449527834792452971981976143292558073856937958553180532878928001494706097394108577585732452307673444020333";

        BigInteger p = new BigInteger(sp);
        BigInteger g = new BigInteger(sg);
        BigInteger h = new BigInteger(sh);

        BigInteger b = new BigInteger(String.valueOf(BigInteger.valueOf((long) Math.pow(2,20))));
        BigInteger x0 = new BigInteger("0");
        BigInteger x1 = new BigInteger("0");
        BigInteger x;

        BigInteger left = h;
        //为等式左边的所有可能值创建一个哈希表
        Map<BigInteger, BigInteger> map = new HashMap<>();
        for (int i = 0; b.compareTo(BigInteger.valueOf(i)) > 0; i++) {
            map.put(left,BigInteger.valueOf(i));
            left = left.multiply(g).mod(p);
        }

        //baseR = g^B
        BigInteger baseR = new BigInteger("1");
        for (int i = 0; b.compareTo(BigInteger.valueOf(i)) > 0; i++) {
            baseR = baseR.multiply(g).mod(p);
        }

        //枚举x0=1,2,3,4....
        BigInteger right = new BigInteger("1");
        for (int i = 1; b.compareTo(BigInteger.valueOf(i)) >= 0; i++) {
            right = right.multiply(baseR).mod(p);
            if (map.containsKey(right)){
                x0 = BigInteger.valueOf(i);
                x1 = map.get(right);
                break;
            }
        }
        x = b.multiply(x0).subtract(x1);
        if (x.equals(BigInteger.valueOf(-1))){
            System.out.println("null");
        }else {
            System.out.println("x0："+x0);
            System.out.println("x1："+x1);
            System.out.println("x："+ x);
        }


    }


}
