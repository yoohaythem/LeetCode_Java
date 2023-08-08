package com.LeetCode.Hot100._071_会议室II_253;

import java.util.Arrays;

//20221116
class MySolution {

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length, num = 0, end = 0, max = 0;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < n; i++) {
            while (ends[end] <= starts[i]) {   // 每次开会前判断有没有多余的会议室，如果有，把他们都退回去
                end++;
                num--;   // 把开完会的会议室都退回去
            }
            num++;   // 每次开会前自己再新开一间会议室
            max = Math.max(max, num);
        }

        /*
        这段 for 循环可以优化:
        for (int i = 0; i < n; i++) {
            // 如果开始时间大于等于结束时间，说明会议室可以复用。
            // 当前空了多少个会议室不用管，只要有就行了，下一个人来的时候会自己判断都没有空的会议室.
            if (ends[end] <= starts[i]) {
                end++;
            } else {    // 否则需要再新开一个房间，开了的会议室不用还回去，放在那就行
                max++;
            }
        }
         */


        return max;
    }

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        System.out.println(mySolution.minMeetingRooms(new int[][]{new int[]{0, 30}, new int[]{5, 15}, new int[]{15, 20}}));
    }

}
