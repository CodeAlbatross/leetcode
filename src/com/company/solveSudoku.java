package com.company;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 空白格用'.'表示。
 *
 */
public class solveSudoku {
    public void solveSudoku(char[][] board) {
        /**
         * 记录某行，某位数字是否已经被摆放
         */
        boolean[][] row = new boolean[9][9];
        /**
         * 记录某列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][9];
        /**
         * 记录某 3x3 宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i<9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    row[i][board[i][j]-1] = true;
                    col[j][board[i][j]-1] = true;
                    block[i/3*3+j/3][board[i][j]-1] = true;
                }
            }
        }
        dfs(board,row,col,block,0,0);

    }
    public boolean dfs(char[][] board,boolean[][] row,boolean[][] col,boolean[][] block, int i, int j){
        while (board[i][j] != '.'){
            if (++j >= 9){
                //换行
                i++;
                j=0;
            }
            if (i >= 9){
                return true;
            }
        }
        for (int num = 0; num < 9; num++){
            int blockIndex = i/3*3 + j/3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]){
                board[i][j] = (char) ('1'+num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board,row,col,block,i,j)){
                    return true;
                }else {
                    //回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }

        }
        return false;
    }
}
