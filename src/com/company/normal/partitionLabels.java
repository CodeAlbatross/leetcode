package com.company.normal;

import java.util.*;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */

public class partitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        //记录每个字母的开始结束坐标
        Map<Character, Integer[]> map = new LinkedHashMap<>();
        //记录每个串的开始结束坐标
        Map<Integer, Integer[]> map2 = new LinkedHashMap<>();
        //遍历s，记录每个字母的开始结束坐标
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), new Integer[]{i, i});
            } else {
                map.get(S.charAt(i))[1] = i;
            }
        }
        //结束标记
        map.put('#', new Integer[]{S.length(), S.length()});

        int end = 0, start = 0;//记录串的开始结束位置
        int count = 1;//串的序号
        start = getFirstOrNull(map)[0];
        end = getFirstOrNull(map)[1];

        for (Map.Entry<Character, Integer[]> entry : map.entrySet()) {
            if (entry.getValue()[0] < end && entry.getValue()[1] < end) {

            } else if (entry.getValue()[0] < end && entry.getValue()[1] > end) {
                end = entry.getValue()[1];

            } else if (entry.getValue()[0] > end) {
                map2.put(count, new Integer[]{start, end});
                ++count;
                start = entry.getValue()[0];
                end = entry.getValue()[1];
            }
        }
        for (Iterator it = map2.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Character, Integer[]> entry = (Map.Entry<Character, Integer[]>) it.next();
            list.add(entry.getValue()[1] - entry.getValue()[0] + 1);
        }
        return list;
    }

    /**
     * 从map中取出第一个key的值
     *
     * @param map
     * @return
     */
    private static Integer[] getFirstOrNull(Map<Character, Integer[]> map) {
        Integer[] obj = null;
        for (Map.Entry<Character, Integer[]> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }
}
