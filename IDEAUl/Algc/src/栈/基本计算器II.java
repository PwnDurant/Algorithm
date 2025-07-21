package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/description/">题目链接</a>
 */
public class 基本计算器II {

    public static int calculate(String _s) {
        Stack<Integer> ret = new Stack<>();
        char[] s = _s.toCharArray();
        char tmp = '+';
        int result = 0;
        for (int i = 0; i < s.length; ) {
            int num = 0;
            if(s[i] == ' '){
                i++;
                continue;
            }
            if(s[i] >= '0' && s[i] <= '9'){
                while(i < s.length && s[i] >= '0' && s[i] <= '9'){
                    num = num * 10 + (s[i] - '0');
                    i++;
                }
                if(tmp == '-') ret.push(num * -1);
                if(tmp == '+') ret.push(num);
                if(tmp == '*') ret.push(ret.pop() * num);
                if(tmp == '/') ret.push(ret.pop() / num);
            }else{
                tmp = s[i];
                i++;
            }
        }
        while(!ret.isEmpty()){
            result += ret.pop();
        }
        return result;
    }

    public static int calculateNew(String _s) {
        Deque<Integer> st = new ArrayDeque<>();
        char op = '+';
        int i = 0,n = _s.length();
        char[] s = _s.toCharArray();
        while(i < n){
            if(s[i] == ' ') i++;
            else if (s[i] >= '0' && s[i] <= '9'){
                int tmp = 0;
                while(i < n && s[i] >= '0' && s[i] <= '9'){
                    tmp = tmp * 10 + (s[i] - '0');
                    i++;
                }
                if(op == '+') st.push(tmp);
                else if (op == '-') st.push(-tmp);
                else if (op == '*') st.push(st.pop() * tmp);
                else st.push(st.pop() / tmp);
            }
            else {
                op = s[i];
                i++;
            }
        }
        int ret = 0;
        while(!st.isEmpty()){
            ret += st.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
        String test = "2048";
        System.out.println(calculate(test));
//        System.out.println(1 * 10 + ('1' - '0'));
    }

}
