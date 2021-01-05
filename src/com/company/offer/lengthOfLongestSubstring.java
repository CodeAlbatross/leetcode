package com.company.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length = 0;
        int[] indexes = new int[128];
        Arrays.fill(indexes,-1);
        //Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++){
            Character c = s.charAt(i);
            if (indexes[c] == -1){
                indexes[c] = i;
                length++;
                //map.put(c,i);
                maxLength = Math.max(maxLength,length);
            }else{
                //i = map.get(c);
                i = indexes[c];
                length = 0;
                Arrays.fill(indexes,-1);
                //map.clear();
            }
        }
        return maxLength;
    }
    public static void main(String... args){
        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
