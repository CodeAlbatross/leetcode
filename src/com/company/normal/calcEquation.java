package com.company.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class calcEquation {
    /**
     * 399. 除法求值
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     *
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     *
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
     *
     *
     *
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 示例 2：
     *
     * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * 输出：[3.75000,0.40000,5.00000,0.20000]
     * 示例 3：
     *
     * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
     * 输出：[0.50000,2.00000,-1.00000,-1.00000]
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        //给每一个字符串赋index
        for (List<String> list : equations){
            for (String s : list){
                if (!map.containsKey(s))
                    map.put(s,count++);
            }
        }
        //建图
        double[][] graph = new double[count][count];
        for (int i = 0; i < count; i++){
            graph[i][i] = 1.0;
        }
        int index = 0;
        for (List<String> list : equations){
            double length = values[index++];
            graph[map.get(list.get(0))][map.get(list.get(1))] = length;
            graph[map.get(list.get(1))][map.get(list.get(0))] = 1/length;
        }
        //floyd算法，计算
        for (int i = 0; i < count ; i++){
            for (int j = 0; j < count; j++){
                for (int k = 0; k < count; k++){
                    if (j==k || graph[j][k] != 0){
                        continue;
                    }
                    if (graph[j][i] != 0 && graph[i][k] != 0){
                        graph[j][k] = graph[j][i] * graph[i][k];
                    }
                }
            }
        }
        //直接从数组中找答案
        index = 0;
        double[] ret = new double[queries.size()];
        for (List<String> list : queries){
            if (!map.containsKey(list.get(0)) || !map.containsKey(list.get(1))){
                ret[index++] = -1.0;
            }else {
                double res = graph[map.get(list.get(0))][map.get(list.get(1))];
                ret[index++] = res == 0 ? -1.0:res;
            }
        }
        return ret;
    }
}
