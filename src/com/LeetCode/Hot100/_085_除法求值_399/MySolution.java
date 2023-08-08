package com.LeetCode.Hot100._085_除法求值_399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//20221125
class MySolution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int count = 0, n = equations.size();
        Map<String, Integer> map = new HashMap<>(2 * n);
        findUnion findUnion = new findUnion(2 * n);
        // 将字符处理成对应的数字
        for (int i = 0; i < n; i++) {
            List<String> ele = equations.get(i);
            String value1 = ele.get(0);
            if (!map.containsKey(value1)) {
                map.putIfAbsent(value1, count);
                count++;
            }
            String value2 = ele.get(1);
            if (!map.containsKey(value2)) {
                map.putIfAbsent(value2, count);
                count++;
            }
            findUnion.union(map.get(value1), map.get(value2), values[i]);
        }

        // 开始查并集
        int qsize = queries.size();
        double[] result = new double[qsize];
        for (int i = 0; i < qsize; i++) {
            String value1 = queries.get(i).get(0);
            String value2 = queries.get(i).get(1);
            if (!map.containsKey(value1) || !map.containsKey(value2)) {
                result[i] = -1.0d;
            } else {
                int id1 = map.get(value1);
                int id2 = map.get(value2);
                result[i] = findUnion.isConnected(id1, id2);
            }
        }
        return result;
    }


    private class findUnion {
        int[] parent;
        double[] weight;

        public findUnion(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                // x / y == value, x / rootX == weight[x], y / rootY == weight[y], rootX / rootY == weight[rootX]
                weight[rootX] = weight[y] * value / weight[x];
            }
        }

        // 寻找当前节点的父节点
        public int find(int x) {
            if (x != parent[x]) {
                // 一边寻找，一边 递归地 做路径压缩
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
