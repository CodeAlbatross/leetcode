package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1178_findNumOfValidWords {
    /**
     * 1178. 猜字谜
     * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
     *
     * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
     *
     * 单词 word 中包含谜面 puzzle 的第一个字母。
     * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
     * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
     * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
     *
     *
     *
     * 示例：
     *
     * 输入：
     * words = ["aaaa","asas","able","ability","actt","actor","access"],
     * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
     * 输出：[1,1,3,2,4,0]
     * 解释：
     * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
     * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
     * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
     * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
     * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
     * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer,Integer> wordsMap = new HashMap<>();
        //1.先用一个26位的二进制数简化保存每一个word
        for (String word : words){
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            //2.将每一个位为1的数目小于7的mask保存进map映射中(puzzle[i].length == 7)
            // key为位相同的word, value为数目
            if (Integer.bitCount(mask) <= 7){
                wordsMap.put(mask,wordsMap.getOrDefault(mask,0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        //3.同样的方式处理puzzles
        // 然后枚举puzzle的每一位的组合,依次对比wordsMap
        // 值相同则说明匹配成功, 把value累加, 最后就是得到匹配的总数
        for (String puzzle : puzzles){
            int count = 0;
            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= 1 << (puzzle.charAt(i) - 'a');
            }
            int temp = mask;
            do {
                int s = temp | 1 << (puzzle.charAt(0) - 'a');//每一个单词的第一位为1
                if (wordsMap.containsKey(s)){
                    count += wordsMap.get(s);
                }
                temp = (temp - 1) & mask;//保证只枚举一开始为1的位置

            }while (temp != mask);
            list.add(count);
        }

        return list;
    }
}
