package com.company.offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class _63_maxProfit {
    /**
     * 维护一个最小值，维护最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int min = prices[0];
        int profit = 0;
        for (int prise : prices) {
            if (prise < min) {
                min = prise;
            } else {
                profit = Math.max(profit, prise - min);
            }
        }
        return profit;
    }
}
