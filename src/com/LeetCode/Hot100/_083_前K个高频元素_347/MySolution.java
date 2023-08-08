package com.LeetCode.Hot100._083_前K个高频元素_347;

import java.security.KeyStore;
import java.util.*;

//20221120
class MySolution {

    // 1. 利用 map + Arrays.sort
    public int[] topKFrequent_1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] counts = new int[map.size()][2];
        int i = 0;
        for (Integer key : map.keySet()) {
            counts[i][0] = key;
            counts[i][1] = map.get(key);
            i++;
        }
        Arrays.sort(counts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = counts[j][0];
        }
        return result;
    }

    // 2. 大根堆 priorityOueue
    // 若是想自己实现堆，则参考63题 MySolution.maxHeapify 的写法
    public int[] topKFrequent_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> stack = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Integer key : map.keySet()) {
            int[] temp = new int[2];
            temp[0] = key;
            temp[1] = map.get(key);
            stack.add(temp);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = stack.poll()[0];
        }
        return result;
    }

    // 3. 快速排序
    public void qsort(List<int[]> lst, int start, int end, int k) {
        if (start == end) {
            return;
        }
        int firstIndex = start + new Random().nextInt(end - start + 1);
        int left = start, right = end;
        Collections.swap(lst, left, firstIndex);
        int[] num = lst.get(left);
        while (left < right) {
            while (left < right && lst.get(right)[1] < num[1]) {
                right--;
            }
            lst.set(left, lst.get(right));
            while (left < right && lst.get(left)[1] >= num[1]) {
                left++;
            }
            lst.set(right, lst.get(left));
        }
        lst.set(left, num);
        if (left < k - 1) {
            qsort(lst, left + 1, end, k);
        } else if (left > k - 1) {
            qsort(lst, start, left - 1, k);
        }
    }


    public int[] topKFrequent_3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> lst = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            lst.add(new int[]{entry.getKey(), entry.getValue()});
        }

        qsort(lst, 0, lst.size() - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = lst.get(i)[0];
        }
        return result;
    }


    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        System.out.println(Arrays.toString(mySolution.topKFrequent_3(new int[]{1, 2}, 2)));
    }

}
