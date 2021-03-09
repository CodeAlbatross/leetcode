package com.company.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 */
public class commonChars {
    public List<String> commonChars(String[] A) {
        int[][] chars = new int[A.length][36];
        for (int j = 0; j< A.length; j++){
            for (int i = 0; i < A[j].length(); i++ ){
                chars[j][A[j].charAt(i)-'a']++;
            }
        }
        List<String> list = new ArrayList<>();
        for (int j = 1; j< A.length; j++){
            for (int i = 0; i < chars[j].length; i++ ){
                if (chars[j-1][i] != 0 && (chars[j][i] == chars[j-1][i])){

                }else chars[0][i] = Math.min(chars[0][i],chars[j][i]);


            }
        }
        for (int i = 0; i < chars[0].length; i++ ){
            if (chars[0][i] != 0){
                for (int j = 0; j<chars[0][i]; j++){
                    list.add(String.valueOf((char)(i+'a')));
                }
            }

        }
        return list;
    }
}
