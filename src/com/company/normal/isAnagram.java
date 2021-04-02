package com.company.normal;

import java.util.ArrayList;
import java.util.List;

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : sc) {
            list.add(c);
        }
        for (int i = 0; i < t.length(); i++) {
            if (list.contains(t.charAt(i))) {
                list.remove((Character) t.charAt(i));
            } else return false;
        }
        return list.isEmpty();

    }

    public static void main(String... args) {
        isAnagram isAnagram = new isAnagram();
        System.out.println(isAnagram.isAnagram("anaram",
                "nagaram"));
    }
}
