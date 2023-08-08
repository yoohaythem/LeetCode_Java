package com.LeetCode.Hot100._059_岛屿数量_200;

import java.util.*;

//20221110
class MySolution {
    public void dfs(char[][] grid, int line, int col) {
        if (line < grid.length && line >= 0 && col < grid[0].length && col >= 0 && grid[line][col] == '1') {
            grid[line][col] = '0';
            dfs(grid, line - 1, col);
            dfs(grid, line + 1, col);
            dfs(grid, line, col - 1);
            dfs(grid, line, col + 1);
        }
    }

    // 1. 深度优先
    public int numIslands_1(char[][] grid) {
        int line = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 2. 广度优先
    public int numIslands_2(char[][] grid) {
        int line = grid.length;
        int col = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    deque.push(new int[]{i, j});
                    while (!deque.isEmpty()) {
                        int[] position = deque.pop();
                        grid[position[0]][position[1]] = '0';
                        if (position[0] > 0 && grid[position[0] - 1][position[1]] == '1') {
                            grid[position[0] - 1][position[1]] = '0';
                            deque.push(new int[]{position[0] - 1, position[1]});
                        }
                        if (position[0] < line - 1 && grid[position[0] + 1][position[1]] == '1') {
                            grid[position[0] + 1][position[1]] = '0';
                            deque.push(new int[]{position[0] + 1, position[1]});
                        }
                        if (position[1] > 0 && grid[position[0]][position[1] - 1] == '1') {
                            grid[position[0]][position[1] - 1] = '0';
                            deque.push(new int[]{position[0], position[1] - 1});
                        }
                        if (position[1] < col - 1 && grid[position[0]][position[1] + 1] == '1') {
                            grid[position[0]][position[1] + 1] = '0';
                            deque.push(new int[]{position[0], position[1] + 1});
                        }
                    }

                }
            }
        }
        return count;
    }

    // 3. 查并集
    int[] p;
    int count;

    public int find(int i){
        if (p[i] == i){
            return p[i];
        }
        return p[i] = find(p[i]);
    }


    public void union(int m, int n) {
        if (find(m) == find(n)) {
            return;
        }
        p[find(m)] = p[find(n)];
        count--;
    }

    public int numIslands_3(char[][] grid) {
        int line = grid.length;
        int col = grid[0].length;
        count = 0;
        p = new int[line * col];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    p[i * col + j] = i * col + j;
                    count++;
                }
            }
        }
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (j < col - 1 && grid[i][j + 1] == '1') {
                        union(i * col + j, i * col + (j + 1));
                    }
                    if (i < line - 1 && grid[i + 1][j] == '1') {
                        union(i * col + j, (i + 1) * col + j);
                    }
                }
            }
        }
        return count;
    }

}
