package com.company;





import com.company.nowcoder.Union;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
    public static void main(String[] args) {

    }
    public static boolean is(int num){
        if (num == 1)
            return false;

        for (int i = 2; i * i  <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }


}