package com.company.offer;

import java.util.Stack;

public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (true){
            if (stack.size() != 0 && i < popped.length && stack.peek() == popped[i]){
                stack.pop();
                ++i;
            }else{
                if (j > pushed.length)
                    break;
                stack.push(pushed[j]);
                ++j;
            }
        }
        return stack.isEmpty();
    }
}
