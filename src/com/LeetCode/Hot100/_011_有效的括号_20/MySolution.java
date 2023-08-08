package com.LeetCode.Hot100._011_有效的括号_20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//20221028
class MySolution {
    public boolean isValid(String s) {
        HashMap<Character, Character> table = new HashMap<>();
        table.put('(', ')');
        table.put('[', ']');
        table.put('{', '}');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (table.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.size() == 0) {   // 这里可以用stack.isEmpty()代替
                    return false;
                }
                char left = stack.pop();
                if (table.get(left) != ch) {   // 这里用stack.peek()可以再弹出元素之前提前判断，与上面判断栈不为空的步骤合写
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
