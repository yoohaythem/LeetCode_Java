package com.LeetCode.Hot100._009_电话号码的字母组合_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//20221027
public class MySolution {

    public List<String> expend_list(List<String> lst, String chars) {
        List<String> result = new ArrayList<>();
        if (lst.size() == 0) {
            for (int i = 0; i < chars.length(); i++) {
                result.add(String.valueOf(chars.charAt(i)));
            }
        }
        for (String ele : lst) {
            for (int i = 0; i < chars.length(); i++) {
                result.add(ele + chars.charAt(i));
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> table = new HashMap<>();
        List<String> result = new ArrayList<>();
        table.put('2', "abc");
        table.put('3', "def");
        table.put('4', "ghi");
        table.put('5', "jkl");
        table.put('6', "mno");
        table.put('7', "pqrs");
        table.put('8', "tuv");
        table.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            result = expend_list(result, table.get(digits.charAt(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        MySolution cls = new MySolution();
//        System.out.println(cls.expend_list(new ArrayList<>(), "abc").toString());
        System.out.println(cls.letterCombinations("234"));
    }
}
