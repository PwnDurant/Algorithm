package 模拟;

public class 专题_40 {

    public static String convert(String ss, int n) {
        char[] s=ss.toCharArray();
        if(n==1) return ss;
        int d=2*n-2;
        int len=ss.length();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<len;i+=d){
            str.append(s[i]);
        }
        for(int k=1;k<n-1;k++){
            for(int i=k,j=d-i;i<len||j<len;i+=d,j+=d){
                if(i<len){
                    str.append(s[i]);
                }
                if(j<len){
                    str.append(s[j]);
                }
            }
        }

        for(int i=n-1;i<len;i+=d){
            str.append(s[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str="PAYPALISHIRING";
        System.out.println(convert(str,4));
    }

}
