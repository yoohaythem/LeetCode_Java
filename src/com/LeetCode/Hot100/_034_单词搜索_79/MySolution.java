package com.LeetCode.Hot100._034_单词搜索_79;

//20221103
class MySolution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;         // 行
        int n = board[0].length;      // 列
        boolean[] result = {false};
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    flag[i][j] = true;
                    dfs(board, flag, 1, word, result, i, j);
                    flag[i][j] = false;
                }
                if (result[0]) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, boolean[][] flag, int position, String word, boolean[] result, int row, int col) {
        if (position == word.length()) {
            result[0] = true;
            return;
        }
        if (!result[0]) {
            if (row + 1 < board.length && !flag[row + 1][col] && board[row + 1][col] == word.charAt(position)) {
                flag[row + 1][col] = true;
                dfs(board, flag, position + 1, word, result, row + 1, col);
                flag[row + 1][col] = false;
            }
            if (row - 1 >= 0 && !flag[row - 1][col] && board[row - 1][col] == word.charAt(position)) {
                flag[row - 1][col] = true;
                dfs(board, flag, position + 1, word, result, row - 1, col);
                flag[row - 1][col] = false;
            }
            if (col + 1 < board[0].length && !flag[row][col + 1] && board[row][col + 1] == word.charAt(position)) {
                flag[row][col + 1] = true;
                dfs(board, flag, position + 1, word, result, row, col + 1);
                flag[row][col + 1] = false;
            }
            if (col - 1 >= 0 && !flag[row][col - 1] && board[row][col - 1] == word.charAt(position)) {
                flag[row][col - 1] = true;
                dfs(board, flag, position + 1, word, result, row, col - 1);
                flag[row][col - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        System.out.println(mySolution.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "cdba"));
    }
}
