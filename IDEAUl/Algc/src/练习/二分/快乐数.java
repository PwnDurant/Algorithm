package 练习.二分;

public class 快乐数 {

    public static int bitSum(int num){
        int ret=0,tmp=0;
        while(num>0){
            tmp=num%10;
            ret+=Math.pow(tmp,2);
            num/=10;
        }
        return ret;
    }

    public static boolean isHappy(int n) {
        int slow=n,fast=n;
        while(true){
            slow=bitSum(slow);
            fast=bitSum(bitSum(fast));
            if(slow==fast) break;;
        }
        slow=n;
        while (true){
            slow=bitSum(slow);
            fast=bitSum(fast);
            if (slow==fast) break;
        }
        if(slow==1) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

}
