package 字符串;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">题目链接</a>
 */
public class 最长回文子串 {


    public static String longestPalindromeOld(String s) {
        int tmp = 0,begin = 0,end = 0;
        int mid = 0,left,right;
        while(mid <= s.length()){
            // 奇数和偶数都要进行处理
            // 为奇数的时候
            left = right = mid;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                left --;
                right ++;
            }
            if(tmp < (right - left - 1)){
                tmp = right - left - 1;
                begin = left + 1;
                end = right - 1;
            }
            mid ++;
        }
        int swap = tmp,fbegin = begin,fend = end;
        tmp = 0;begin = 0;end = 0;mid = 0;
        while(mid <= s.length()){
            // 奇数和偶数都要进行处理
            // 为奇数的时候
            left = mid;right = mid + 1;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                left --;
                right ++;
            }
            if(tmp < (right - left - 1)){
                tmp = right - left - 1;
                begin = left + 1;
                end = right - 1;
            }
            mid ++;
        }
        begin = (tmp > swap?begin:fbegin);
        end = (tmp > swap?end:fend);
        return s.substring(begin,end + 1);
    }

    public static String longestPalindromeNew(String s) {
        int begin = 0,len = 0,n = s.length();
        for (int i = 0; i < n; i++) { // 固定所有中间节点
            // 先拓展奇数长度的子串
            int left = i,right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            if (right - left -1 > len){
                begin = left + 1;
                len = right - left -1;
            }
            // 拓展偶数长度
            left = i;right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            if(right - left - 1 > len){
                begin = left + 1;
                len = right - left - 1;
            }
        }
        return s.substring(begin,begin + len);
    }

    public static void main(String[] args) {
        String s = "abbb";
        System.out.println(longestPalindromeNew(s));
    }

}
