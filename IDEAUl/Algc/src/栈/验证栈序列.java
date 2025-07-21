package 栈;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/validate-stack-sequences/description/">题目链接</a>
 */
public class 验证栈序列 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : popped) {
            while(stack.isEmpty() || (i < pushed.length && num != stack.peek())){
                stack.push(pushed[i]);
                i++;
            }
            if(stack.peek() == num) stack.pop();
        }
        return stack.isEmpty();
    }

    public static boolean validateStackSequencesNew(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int i = 0,n = popped.length;
        for (int x : pushed) {
            stack.push(x);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return i == n;
    }

    public static void main(String[] args) {
//        pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        int[] pushed = {1,2,3,4,5};
        int[] poped1 = {4,5,3,2,1};
        int[] poped2 = {4,3,5,1,2};
        System.out.println(validateStackSequences(pushed,poped1));
        System.out.println(validateStackSequencesNew(pushed,poped2));
    }

}
