package com.LeetCode.Hot100._086_根据身高重建队列_406;

import java.util.*;

//20221121
class MySolution {

    // 1. 从大到小
    public int[][] reconstructQueue_1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] != o1[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[][] p = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        for (int i = 0; i < people.length; i++) {
            p[i] = res.get(i);
        }
        return p;
    }

    // 2. 从大到小
    public int[][] reconstructQueue_2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] != o1[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        int[][] result = new int[people.length][];
        for (int[] ele : people) {
            int space = ele[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (result[i] == null) {
                    space--;
                    if (space == 0) {
                        result[i] = ele;
                        break;
                    }
                }
            }
        }
        return result;
    }

}
