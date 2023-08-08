package com.LeetCode.Hot100._084_字符串解码_394;

import java.util.Deque;
import java.util.LinkedList;

//20221120
class MySolution {

    // 1. 递归
    public String decodeString_1(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int left = 0;
        StringBuilder multi = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left == 0) {
                if (c <= 'z' && c >= 'a') {
                    sb.append(c);
                } else if (c <= '9' && c >= '0') {
                    multi.append(c);
                } else if (c == '[') {
                    left++;
                }
            } else {
                temp.append(c);
                if (c == '[') {
                    left++;
                } else if (c == ']') {
                    left--;
                }
                if (left == 0) {
                    for (int j = 0; j < Integer.parseInt(multi.toString()); j++) {
                        sb.append(decodeString_1(temp.toString()));
                    }
                    temp = new StringBuilder();
                    multi = new StringBuilder();
                }
            }
        }
        return sb.toString();
    }

    // 2. 栈
    public String decodeString_2(String s) {
        Deque<Integer> num_stack = new LinkedList<>();
        Deque<String> str_stack = new LinkedList<>();
        str_stack.push("");
        StringBuilder str_temp = new StringBuilder();
        StringBuilder num_temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(i);
            if (c <= 'z' && c >= 'a') {
                str_temp.append(c);
            } else if (c <= '9' && c >= '0') {
                num_temp.append(c);
            } else if (c == '[') {
                /*
                    1. 数字栈入栈
                    2. 修改字符栈栈顶元素
                    3. 字符栈新增一个空字符串，为后面考虑
                 */
                if (num_temp.length() != 0) {   // 因为数字与 '[' 总是伴生，这个判断可以不做。事实上如果不伴生，那么这里会出问题
                    num_stack.push(Integer.parseInt(num_temp.toString()));
                    num_temp.setLength(0);
                }
                str_stack.push(str_stack.pop() + str_temp);
                str_temp.setLength(0);
                str_stack.push("");
            } else if (c == ']') {
                /*
                    1. 修改字符栈栈顶元素
                    2. 将字符栈栈顶元素 * 数字栈栈顶元素，双双出栈
                    3. 将 2 的结果，追加到字符栈栈顶元素后
                 */
                str_stack.push(str_stack.pop() + str_temp);
                str_temp.setLength(0);
                StringBuilder units = new StringBuilder();
                String unit = str_stack.pop();
                Integer multi = num_stack.pop();
                for (int j = 0; j < multi; j++) {
                    units.append(unit);
                }
                str_stack.push(str_stack.pop() + units);
            }
        }
        return str_stack.pop() + str_temp;
    }


    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        String s = mySolution.decodeString_2("4[2[jk]e1[f]]");
        System.out.println(s);
    }

}
