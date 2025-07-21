package 字符串;

/**
 * <a href="https://leetcode.cn/problems/add-binary/description/">题目链接</a>
 */
public class 二进制求和 {

    public static String addBinary(String a, String b) {
        int cur1 = a.length() - 1,cur2 = b.length() - 1,tmp = 0;
        StringBuilder result = new StringBuilder();
        while(cur1 >= 0 || cur2 >= 0 || tmp != 0){
            if(cur1 >= 0) tmp += a.charAt(cur1--) - '0';
            if(cur2 >= 0) tmp += b.charAt(cur2--) - '0';
            result.append((char) ('0' + (char) (tmp % 2)));
            tmp /= 2;
        }
        result.reverse();
        return new String(result);
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }

}
