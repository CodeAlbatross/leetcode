package com.company.nowcoder;

import java.util.Scanner;

public class sudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] sudoku = new int[9][9];
        boolean[][] hang = new boolean[9][9];
        boolean[][] lie = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = in.nextInt();

            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != 0) {
                    hang[i][sudoku[i][j] - 1] = true;
                    lie[j][sudoku[i][j] - 1] = true;
                    block[i / 3 * 3 + j / 3][sudoku[i][j] - 1] = true;
                }

            }
        }

        dfs(sudoku, hang, lie, block, 0, 0);

    }


    private static boolean dfs(int[][] sudoku, boolean[][] hang, boolean[][] lie, boolean[][] block, int i, int j) {
        while (sudoku[i][j] != 0) {
            while (sudoku[i][j] != 0) {
                if (++j >= 9) {
                    //换行
                    i++;
                    j = 0;
                }
                if (i >= 9) {
                    for (int x = 0; x < 9; x++) {
                        for (int y = 0; y < 9; y++) {
                            System.out.print(sudoku[x][y]);
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                    return true;
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            int blo = i / 3 * 3 + j / 3;
            if (!hang[i][k] && !lie[j][k] && !block[blo][k]) {
                hang[i][k] = true;
                lie[j][k] = true;
                block[blo][k] = true;
                sudoku[i][j] = k + 1;
                if (dfs(sudoku, hang, lie, block, i, j)) {
                    return true;
                } else {
                    hang[i][k] = false;
                    lie[j][k] = false;
                    block[blo][k] = false;
                    sudoku[i][j] = 0;
                }
            }
        }
        return false;
    }
}
