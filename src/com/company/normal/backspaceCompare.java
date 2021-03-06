package com.company.normal;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
public class backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        int a = S.length() - 1, count1 = 0;
        int b = T.length() - 1, count2 = 0;
        while (a >= 0 || b >= 0) {
            while (a >= 0) {
                if (S.charAt(a) == '#') {
                    ++count1;
                    a--;
                } else if (count1 > 0) {
                    --count1;
                    a--;
                } else break;
            }
            while (b >= 0) {
                if (T.charAt(b) == '#') {
                    ++count2;
                    b--;
                } else if (count2 > 0) {
                    --count2;
                    b--;
                } else break;
            }
            if (a >= 0 && b >= 0) {
                if (S.charAt(a) == T.charAt(b)) {
                    --a;
                    --b;
                } else return false;
            } else break;
        }
        return a == b;
    }
}
