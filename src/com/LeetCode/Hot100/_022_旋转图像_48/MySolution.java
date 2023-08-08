package com.LeetCode.Hot100._022_旋转图像_48;

//20221031
class MySolution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                my_change(matrix, i, j);
            }
        }
    }

    public void my_change(int[][] matrix, int i, int j) {  // i：行，j：列
        int n = matrix.length - 1;
        int swap = matrix[i][j];
        matrix[i][j] = matrix[n - j][i];
        matrix[n - j][i] = matrix[n - i][n - j];
        matrix[n - i][n - j] = matrix[j][n - i];
        matrix[j][n - i] = swap;
    }
}
