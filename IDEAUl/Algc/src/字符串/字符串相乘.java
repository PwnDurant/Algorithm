package 字符串;

/**
 * <a href="https://leetcode.cn/problems/multiply-strings/description/">题目链接</a>
 */
public class 字符串相乘 {

    public static String multiply(String num1, String num2) {
        // 使用无进位相加做乘法
        char[] n1 = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuffer(num2).reverse().toString().toCharArray();
        int[] ret = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++)
            for (int j = 0; j < num2.length(); j++)
                ret[i + j] += (n1[i] - '0') * (n2[j] - '0');
        int cur = 0,tmp  = 0;
        StringBuffer result = new StringBuffer();
        while(cur < ret.length || tmp != 0){
            if(cur < ret.length) tmp += ret[cur];
            result.append((char) ((char)(tmp % 10) + '0'));
            tmp /= 10;
            cur ++;
        }
        // 解决前导0
        while(result.charAt(result.length() - 1) == '0' && result.length() > 1){
            result.deleteCharAt(result.length() - 1);
        }
        return new String(result.reverse());
    }


    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        System.out.println(multiply(a,b));
//        System.out.println(8/10);
    }

}
