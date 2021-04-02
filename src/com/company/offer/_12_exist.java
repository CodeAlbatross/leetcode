package com.company.offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class _12_exist {
    int[] xs = new int[]{1, -1, 0, 0};
    int[] ys = new int[]{0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int i) {
        if (x > board.length - 1 || y > board[0].length - 1 || x < 0 || y < 0 || board[x][y] != word.charAt(i))
            return false;
        if (i == word.length() - 1)
            return true;
        boolean res = false;
        board[x][y] = '\0';
        for (int j = 0; j < 4; j++) {
            res = dfs(board, word, x + xs[j], y + ys[j], i + 1);
            if (res)
                break;
        }
        board[x][y] = word.charAt(i);//此处需要恢复现场
        return res;
    }
}
