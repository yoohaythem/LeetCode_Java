package com.LeetCode.Hot100._026_合并区间_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//20221101
class MySolution {
    public int[][] merge(int[][] intervals) {

        // 自定义排序规则
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> artaylst = new ArrayList<>();
        int[] temp = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(intervals[i][1],temp[1]);
            } else {
                artaylst.add(temp);
                temp = intervals[i];
            }
        }
        artaylst.add(temp);

        // 这几步可以优化
        int[][] result = new int[artaylst.size()][2];

        for (int i = 0; i < artaylst.size(); i++) {
            result[i] = artaylst.get(i);
        }

        return result;
    }

}
