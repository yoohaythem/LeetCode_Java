package com.LeetCode.Hot100._023_字母异位词分组_49;


import java.util.*;

class OfficialSolution {

    // 1. 排序
    public List<List<String>> groupAnagrams_1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // 如何将Srring排序
            char[] array = str.toCharArray();  // 1. String转为字符数组
            Arrays.sort(array);  // 2. 字符数组排序
            String key = new String(array);  // 3. 将字符数组转为String

            // 获取字典中的值，如果没有则给默认值
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        // 将字典的键转为数组的方法
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams_2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}

