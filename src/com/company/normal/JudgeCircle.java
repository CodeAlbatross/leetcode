package com.company.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lzyyy
 */
public class JudgeCircle {
    public Map<Character, int[]> map = Map.of(
            'R', new int[]{1, 0},
            'L', new int[]{-1, 0},
            'U', new int[]{0, -1},
            'D', new int[]{0, 1}
    );

    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) {
            return true;
        } else if (moves.length() == 1) {
            return false;
        }
        int[] a = new int[2];
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    a[0] += 1;
                    break;
                case 'L':
                    a[0] -= 1;
                    break;
                case 'U':
                    a[1] -= 1;
                    break;
                case 'D':
                    a[1] += 1;
                    break;
                default:
            }
        }
        return a[0] == 0 && a[1] == 0;
    }
}
