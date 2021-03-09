package com.company.normal;

import java.util.*;

public class smallestStringWithSwaps {
    /**
     * 1202. 交换字符串中的元素
     * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
     *
     * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
     *
     * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
     *
     *
     *
     * 示例 1:
     *
     * 输入：s = "dcab", pairs = [[0,3],[1,2]]
     * 输出："bacd"
     * 解释：
     * 交换 s[0] 和 s[3], s = "bcad"
     * 交换 s[1] 和 s[2], s = "bacd"
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0){
            return s;
        }
        // 第 1 步：将任意交换的结点对输入并查集
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> list : pairs){
            int index1 = list.get(0);
            int index2 = list.get(1);
            unionFind.merge(index1,index2);
        }

        // 第 2 步：构建映射关系
        char[] charArrays = s.toCharArray();
        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++){
            int root = unionFind.find(i);
            if (hashMap.containsKey(root)){
                hashMap.get(root).offer(charArrays[i]);
            }else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(charArrays[i]);
                hashMap.put(root,minHeap);
            }
        }
        // 第 3 步：重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++){
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();

    }

}
