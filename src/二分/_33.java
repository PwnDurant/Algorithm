package 二分;

public class _33 {
    public boolean isUnique(String astr){
        if(astr.length()>26) return false;

        int bitMap=0;
        for(int i=0;i<astr.length();i++){
            int x=astr.charAt(i)-'a';
            if(((bitMap>>x)&1)==1) return false;
            bitMap |=1 <<x;
        }
        return true;
    }
}
