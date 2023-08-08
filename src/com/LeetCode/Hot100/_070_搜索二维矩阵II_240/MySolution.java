package com.LeetCode.Hot100._070_搜索二维矩阵II_240;

//20221115
class MySolution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, line = 0, col = n - 1;
        while (line < m && col >= 0) {
            if (matrix[line][col] == target) {
                return true;
            } else if (matrix[line][col] < target) {
                line++;
            } else {
                col--;
            }
        }
        return false;
    }

}
