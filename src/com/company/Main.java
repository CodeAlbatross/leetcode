package com.company;


import com.company.normal.ListNode;

import java.util.*;

public class Main {
    public static void main(String[] args){
        char[] input = " ((1-(((3-1)*2+7) - (9*2-8/1)*2))*2)".toCharArray();

        Stack<Float> num = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for(int i = 0; i< input.length;i++){
            char c = input[i];
            if(c == ' '){
            }else if(c == '+' || c == '-' || c =='(' || c =='*' || c =='/'){
                ops.push(c);
            }else if(c == ')'){
                while(!ops.isEmpty() && ops.peek() != '('){
                    float a = num.pop();
                    float b = num.pop();
                    char op = ops.pop();
                    if(op == '+'){
                        num.push(a + b);
                    }else if(op == '-'){
                        num.push( b - a );
                    }
                }
                ops.pop();
            }
            else{
                float temp = c-'0';
                while(i < input.length-1 && input[i+1] < '9' && input[i+1] > '0'){
                    c = input[++i];
                    temp = temp*10+(c - '0');
                }
                if(!ops.isEmpty() && ops.peek() == '*'){
                    num.push(temp * num.pop());
                    ops.pop();
                }else if(!ops.isEmpty() && ops.peek() == '/'){
                    num.push(num.pop() / temp);
                    ops.pop();
                }else {
                    num.push(temp);
                }

            }

        }
        float ret = 0;
        while (!num.isEmpty()){
            ret += num.pop();
        }
        System.out.println(ret);
    }

    }

