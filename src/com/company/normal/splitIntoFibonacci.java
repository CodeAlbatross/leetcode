package com.company.normal;

import java.util.ArrayList;
import java.util.List;

public class splitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backTrack(0, list, S);
        return list;
    }

    private boolean backTrack(int index, List<Integer> list, String S) {
        if (index == S.length() && list.size() >= 3) {
            return true;
        }
        for (int i = index; i < S.length(); i++) {
            if (S.charAt(i) == '0' && i > index) {
                break;
            }
            long num = Long.parseLong(S.substring(index, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (backTrack(i + 1, list, S))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String... args) {
        System.out.println(new splitIntoFibonacci().splitIntoFibonacci("123456579"));
    }
}