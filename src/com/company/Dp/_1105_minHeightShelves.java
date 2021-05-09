package com.company.Dp;

import java.util.Arrays;

/**
 * 1105. 填充书架
 * 附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。
 *
 * 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。
 *
 * 按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 *
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 *
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 *
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 *
 * 以这种方式布置书架，返回书架整体可能的最小高度。
 */
public class _1105_minHeightShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        //dp[i] 表示放置前 i 本书所需要的书架最小高度
        int[] dp = new int[books.length+1];
        Arrays.fill(dp,1000000);
        dp[0] = 0;
        // 遍历每一本书，把当前这本书作为书架最后一层的最后一本书，
        // 将这本书之前的书向后调整，看看是否可以减少之前的书架高度
        for (int i = 0; i < books.length; i++) {
            int temp_w = 0, j = i, h = 0;
            while (j>0){
                temp_w += books[i][0];//临时的宽
                if (temp_w > shelf_width) break;
                h = Math.max(h,books[j-1][1]);//这一层最高的高度
                dp[i] = Math.min(dp[i],dp[j-1]+h);
                --j;
            }
        }
        return dp[books.length];
    }
}
