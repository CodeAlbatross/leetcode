package com.company.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class groupAnagrams {
    /**
     * 49. 字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int[][] nums = new int[strs.length][26];
        int[] empty = new int[26];
        int count = strs.length;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                ++nums[i][aChar - 'a'];
            }
            if (str.equals("")) {
                list.add(str);
                count--;
            }
        }
        if (!list.isEmpty())
            lists.add(new ArrayList<>(list));


        while (count > 0) {
            list.clear();
            int[] key = new int[26];//保存key变量的下标
            for (int i = 0; i < strs.length; i++) {
                if (!Arrays.equals(nums[i], empty)) {
                    if (list.isEmpty()) {
                        list.add(strs[i]);
                        key = nums[i].clone();
                        Arrays.fill(nums[i], 0);
                        count--;
                    } else {
                        if (Arrays.equals(nums[i], key)) {
                            list.add(strs[i]);
                            count--;
                            Arrays.fill(nums[i], 0);
                        }
                    }
                }
            }
            lists.add(new ArrayList<>(list));
        }

        return lists;
    }

    public static void main(String... args) {
        System.out.println(new groupAnagrams().groupAnagrams(new String[]{"", "", "a", ""}));
    }
}
