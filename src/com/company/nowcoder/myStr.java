package com.company.nowcoder;

import java.util.*;

public class myStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            Set<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            StringBuilder res = new StringBuilder();
            for (char c : set) {
                res.append(c);
            }
            System.out.println(res);

        }
    }
}
