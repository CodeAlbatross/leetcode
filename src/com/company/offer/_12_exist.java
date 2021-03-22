package com.company.offer;

public class _12_exist {
    int[] xs = new int[]{1,-1,0,0};
    int[] ys = new int[]{0,0,1,-1};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }
    private boolean dfs(char[][] board, String word, int x, int y, int i){
        if (x > board.length-1 || y > board[0].length-1 || x < 0 || y < 0 || board[x][y] != word.charAt(i))
            return false;
        if (i == word.length()-1)
            return true;
        boolean res = false;
        board[x][y] = '\0';
        for (int j = 0; j < 4; j++) {
            res = dfs(board,word,x+xs[j],y+ys[j],i+1);
            if (res)
                break;
        }
        board[x][y] = word.charAt(i);
        return res;
    }
}
