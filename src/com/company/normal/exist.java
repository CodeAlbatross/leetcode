package com.company.normal;
/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class exist {
    public boolean aBoolean = false;
    public int[] xs = {0,0,1,-1};
    public int[] ys = {1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return false;
        }

        int[][] visited = new int[board.length][board[0].length];
        int x1 = -1 , y1 = -1;
        for1:for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){

                if (board[i][j] == word.charAt(0)){
                    x1 = i;
                    y1=  j;
                    break for1;
                }
            }
        }
        if (x1 == -1) return false;
        for (; x1 < board.length; x1++){
            for (; y1 < board[0].length; y1++){
                if (aBoolean) return true;
                dfs(board,word,x1,y1,0,visited);
            }
            y1 = 0;
        }

        return aBoolean;
    }
    public boolean dfs(char[][] board, String word, int x, int y, int index,int[][] visted){

        if (index == word.length()){
            aBoolean = true;
            return true;
        }
        if (aBoolean) return true;
        if (x<0 || x > board.length-1 || y < 0 || y > board[0].length-1 || visted[x][y] == 1){
            return false;
        }

        if (board[x][y] != word.charAt(index)){
            return false;
        }
        for (int i = 0; i < xs.length; i++){
            visted[x][y] = 1;
            dfs(board,word,x+xs[i],y+ys[i],index+1,visted);
            visted[x][y] = 0;
        }
        return false;
    }
}
