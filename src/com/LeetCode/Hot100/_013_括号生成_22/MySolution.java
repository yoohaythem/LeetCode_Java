package com.LeetCode.Hot100._013_括号生成_22;

import java.util.ArrayList;
import java.util.List;

//20221029
class MySolution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generator(result, new StringBuffer(), n, n);
        return result;
    }


    public void generator(List<String> result, StringBuffer temp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(temp.toString());
        } else if (right == 0 || left >= right) {
            temp.append('(');
            generator(result, temp, left - 1, right);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            if (left > 0){         // 这里的判断逻辑还可以优化，与上面的逻辑合并。需要在第一个条件后面强行加上 return; 。
                temp.append('(');
                generator(result, temp, left - 1, right);
                temp.deleteCharAt(temp.length() - 1);
            }
            temp.append(')');
            generator(result, temp, left, right - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }


    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        System.out.println(mySolution.generateParenthesis(3).toString());
    }

}
