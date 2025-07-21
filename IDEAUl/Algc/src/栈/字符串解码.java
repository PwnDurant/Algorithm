package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/decode-string/">题目链接</a>
 */
public class 字符串解码 {

    public static String decodeString(String _s) {
        Stack<StringBuilder> strings = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        char[] s = _s.toCharArray();
        int n = s.length,i = 0;
        while(i < n){
            if(s[i] >= '0' && s[i] <= '9'){
                int num = 0;
                while(i < n && s[i] >= '0' && s[i] <= '9'){
                    num = num * 10 + (s[i] - '0');
                    i++;
                }
                integers.push(num);
            } else if (s[i] >= 'a' && s[i] <= 'z') {
                StringBuilder builder = new StringBuilder();
                while(i < n && s[i] >= 'a' && s[i] <= 'z'){
                    builder.append(s[i]);
                    i ++ ;
                }
                if(!strings.isEmpty()) strings.push(strings.pop().append(builder));
                else strings.push(builder);
            } else if (s[i] == '[') {
                i++;
                StringBuilder builder = new StringBuilder();
                while(i < n && s[i] >= 'a' && s[i] <= 'z'){
                    builder.append(s[i]);
                    i ++ ;
                }
                strings.push(builder);
            } else {
                StringBuilder tmp = new StringBuilder();
                int len = integers.pop();
                for (int j = 0; j < len; j++) {
                    tmp.append(strings.peek());
                }
                strings.pop();
                if(!strings.isEmpty()) strings.push(strings.pop().append(tmp));
                else strings.push(tmp);
                i++;
            }
        }

        StringBuilder result = new StringBuilder();
        String[] result_s = new String[strings.size()];
        int size = strings.size();
        for (int j = 0; j < size; j++) {
            result_s[j] = strings.pop().toString();
        }
        for (int j = result_s.length - 1; j >= 0 ; j--) {
            result.append(result_s[j]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        String s1 = "3[a]2[bc]";
//        String s2 = "3[a2[c]]";
//        String s3 = "abc3[cd]xyz";
//        System.out.println(decodeString(s1));
//        System.out.println(decodeString(s2));
//        System.out.println(decodeString(s3));
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s1 = "abc3[cd]xyz";
        System.out.println(decodeString(s1));
    }

}
