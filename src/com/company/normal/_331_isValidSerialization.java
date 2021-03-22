package com.company.normal;

import java.util.Deque;
import java.util.LinkedList;

public class _331_isValidSerialization {
    public boolean isValidSerialization(String preorder) {
        Deque<Character> stack = new LinkedList<>();
        int len = preorder.length();
        int i = 0;
        while (i < len) {
            char c = preorder.charAt(i);
            switch (c){
                case ',' -> ++i;
                case '#' -> {
                    if (!stack.isEmpty() && stack.peek() == '#'){
                        stack.pop();
                        if (stack.isEmpty()){
                            return false;
                        }else {
                            stack.pop();
                        }
                    }else {
                        stack.push(c);
                        ++i;
                    }
                }
                default -> {
                    stack.push(c);
                    while (i < len && preorder.charAt(i) >= '0'){
                        ++i;
                    }

                }

            }
        }
        return stack.size() == 1 && stack.peek() == '#';
    }

    public static void main(String[] args) {
        System.out.println(new _331_isValidSerialization().isValidSerialization("91,13,14,#,#,10"));
    }
}
