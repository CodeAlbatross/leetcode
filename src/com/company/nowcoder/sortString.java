package com.company.nowcoder;

import java.util.*;

public class sortString {
    public static class word{
        public Character c;
        public Integer index;

        public word(Character c, Integer index) {
            this.c = c;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            word word = (word) o;
            return Objects.equals(c, word.c) && Objects.equals(index, word.index);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, index);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            Map<Integer, Character> others = new HashMap<>();
            Map<word,Integer> alp = new TreeMap<>(new Comparator<word>() {
                @Override
                public int compare(word o1, word o2) {
                    char c1 = Character.toLowerCase(o1.c),c2 = Character.toLowerCase(o2.c);
                    Integer in1 = o1.index, in2 = o2.index;
                    if (c1 != c2){
                        return c1 - c2;
                    }else {
                        return in1 - in2;
                    }
                }
            });
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if (!Character.isAlphabetic(chars[i])){
                    others.put(i,chars[i]);
                }else {
                    alp.put(new word(chars[i],i),i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (word w : alp.keySet()){
                sb.append(w.c);
            }
            int j = 0;
            char[] ret = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                if (others.containsKey(i)){
                    ret[i] = others.get(i);
                }else {
                    ret[i] = sb.charAt(j++);
                }
            }

            System.out.println(String.valueOf(ret));
        }

    }
}
