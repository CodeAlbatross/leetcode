package com.company;

import com.company.offer.*;

import javax.management.StandardEmitterMBean;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.RunnableFuture;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {

        /*TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);*/
        System.out.println(AccountType.FIXED);
    }
    enum AccountType
    {
        SAVING, FIXED, CURRENT;
        private AccountType()
        {
            System.out.println("It is a account type");
        }
    }


    private int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
