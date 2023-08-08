package com.LeetCode.Hot100._061_课程表_207;

import java.util.*;

//20221110
class MySolution {
    public boolean canFinish_1(int numCourses, int[][] prerequisites) {
        int[] in_degree = new int[numCourses];
        List<List<Integer>> out = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            out.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            in_degree[prerequisite[1]]++;
            out.get(prerequisite[0]).add(prerequisite[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int study = q.poll();
            count++;
            for (int ele : out.get(study)) {
                in_degree[ele]--;
                if (in_degree[ele] == 0) {
                    q.offer(ele);
                }
            }
        }
        return count == numCourses;
    }


    int[] visited;  // 0--未搜索，1--搜索中，2--搜索完成
    boolean result = true;
    List<List<Integer>> out;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        out = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            out.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            out.get(prerequisite[0]).add(prerequisite[1]);
        }
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return result;
    }

    public void dfs(int n) {
        visited[n] = 1;
        for (int ele : out.get(n)) {
            if (visited[ele] == 0) {
                dfs(ele);
                if (!result){
                    return;
                }
            } else if (visited[ele] == 1) {
                result = false;
                return;
            }
        }
        visited[n] = 2;
    }
}
