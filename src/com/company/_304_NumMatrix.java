package com.company;

class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int length = matrix.length;
        if (length > 0){
            int width = matrix[0].length;
            sums = new int[length+1][width+1];
            for (int i = 1; i <= length; i++) {
                for (int j = 1; j <= width; j++) {
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1+=1;
        row2+=1;
        col1+=1;
        col2+=1;
        return sums[row2][col2] - sums[row1-1][col2] - sums[row2][col1-1] + sums[row1-1][col1-1];
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{-4,-5}
        });
        System.out.println(numMatrix.sumRegion(0,1,0,1));

    }
}
