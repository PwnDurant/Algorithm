package 模拟;

public class 专题_41 {

    public static String countAndSay(int n) {
        String ret="1";
        for(int i=1;i<n;i++){
            StringBuilder tmp=new StringBuilder();
            int len=ret.length();
            for(int left=0,right=0;right<len;){
                while(right<len&&ret.charAt(left)==ret.charAt(right)) right++;
                tmp.append(Integer.toString(right-left));
                tmp.append(ret.charAt(left));
                left=right;
            }
            ret=tmp.toString();
        }
        return ret;
    }

    public static String count(int n){
        String ret="1";
        for(int i=1;i<n;i++){
            StringBuilder str=new StringBuilder();
            int len=ret.length();
            for(int left=0,right=0;right<len;){
                while(right<len&&ret.charAt(left)==ret.charAt(right)) right++;
                str.append(Integer.toString(right-left));
                str.append(ret.charAt(left));
                left=right;
            }
            ret=str.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(count(4));
    }
}
