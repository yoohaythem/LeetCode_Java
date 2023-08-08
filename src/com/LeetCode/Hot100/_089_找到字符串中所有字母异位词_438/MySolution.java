package com.LeetCode.Hot100._089_找到字符串中所有字母异位词_438;

import java.util.*;

//20221121
class MySolution {

    public List<Integer> findAnagrams(String s, String p) {
        int[] pList = new int[26];
        int[] sList = new int[26];
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            pList[p.charAt(i) - 'a'] += 1;
            sList[s.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(pList, sList)) {
            result.add(0);
        }
        int left = 0, right = p.length();
        while (right < s.length()) {
            sList[s.charAt(right) - 'a'] += 1;
            sList[s.charAt(left) - 'a'] -= 1;
            left++;
            right++;
            if (Arrays.equals(pList, sList)) {
                result.add(left);
            }
        }
        return result;
    }

}
