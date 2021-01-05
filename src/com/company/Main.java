package com.company;

import org.w3c.dom.ls.LSOutput;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Deque;
import java.util.LinkedList;

public class Main{

    
    public static void main(String[] args) {

    }
    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1)
            return s;
        int[] counts = new int[26];
        for (int i = 0; i< s.length(); i++){
            ++counts[s.charAt(i) - 'a'];
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            while (!deque.isEmpty() && !deque.contains(c) && counts[deque.peekLast() - 'a'] > 1 && deque.peekLast() > c){
                --counts[deque.pollLast() - 'a'];
            }
            if (deque.contains(c)){
                --counts[c - 'a'];
            }else {
                deque.addLast(c);
            }

        }
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

}
