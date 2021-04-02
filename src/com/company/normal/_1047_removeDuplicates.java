package com.company.normal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class _1047_removeDuplicates {
    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            Character c = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != c) {
                deque.offerFirst(c);
            } else {
                deque.pollFirst();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _1047_removeDuplicates().removeDuplicates("abbaca"));
    }
}
