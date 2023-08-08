package com.LeetCode.Hot100._077_删除无效的括号_301;

import java.util.*;

//20221119
class MySolution {

    // 1. 深度优先
    private List<String> result = new ArrayList<>();

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public void traceback(String s, int start, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (left + right > s.length() - i) {
                return;
            }
            if (left > 0 && s.charAt(i) == '(') {
                traceback(s.substring(0, i) + s.substring(i + 1), i, left - 1, right);
            }
            if (right > 0 && s.charAt(i) == ')') {
                traceback(s.substring(0, i) + s.substring(i + 1), i, left, right - 1);
            }
        }

    }


    public List<String> removeInvalidParentheses_1(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        traceback(s, 0, left, right);

        return result;
    }


    // 2. 广度优先
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> temp = new HashSet<>();
        List<String> result = new ArrayList<>();
        temp.add(s);

        while (true) {
            for (String ele : temp) {
                if (isValid(ele)) {
                    result.add(ele);
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
            HashSet<String> loop = new HashSet<>();
            for (String ele : temp) {
                for (int i = 0; i < ele.length(); i++) {
                    if (i != 0 && ele.charAt(i) == ele.charAt(i - 1)) {
                        continue;
                    }
                    if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                        loop.add(ele.substring(0, i) + ele.substring(i + 1));
                    }
                }
            }
            temp = loop;
        }
    }


}
