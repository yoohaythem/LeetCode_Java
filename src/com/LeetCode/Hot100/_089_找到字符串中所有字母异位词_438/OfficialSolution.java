package com.LeetCode.Hot100._089_找到字符串中所有字母异位词_438;

import java.util.*;

class OfficialSolution {

    // 1. 滑动窗口
    public List<Integer> findAnagrams_1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    // 2. 优化的滑动窗口
    public List<Integer> findAnagrams_2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    // 3. 非定长滑动窗口
    /*
        初始化p的字符数组然后维护数组每个元素不小于0。 开始向右滑动窗口，减去并相应字符，如果频率小于0就收缩左侧边界直到频率不再小于0。
        窗口长度与p长度一致时达成条件。
     */
    public static List<Integer> findAnagrams_3(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        //统计需要的字符及其数量
        int[] need = new int[26];
        for (char c : pCharArray) {
            need[c - 'a']++;
        }

        //移动窗口
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char rightChar = sCharArray[right];
            --need[rightChar - 'a'];
            while (need[rightChar - 'a'] < 0) {  //移动左边界直到这个负数变成非负数    ++left 要放在最后
                char leftChar = sCharArray[left];
                ++need[leftChar - 'a'];
                ++left;
            }
            //如果窗口长度 == s.length()，那么就是可行解
            if (right - left + 1 == p.length()) {
                list.add(left);
            }
            right++;  //移动右边界
        }
        return list;
    }

}

