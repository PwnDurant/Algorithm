package 双指针;

public class Happy_number {
//    将每一位的数字平方之后再进行求和
    public static int bitSum(int num){
        int n,ret=0;
        while(num>0){
            n=num%10;
            ret+=Math.pow(n,2);
            num/=10;
        }
        return ret;
    }

    public  boolean isHappy(int n) {
//        先用快慢指针找到相遇点
        int slow=n,fast=n;
        while(true){
            slow=bitSum(slow);
            fast=bitSum(bitSum(fast));
            if(slow==fast) break;
        }
//        找到相遇点之后再以相同速度行走相遇点就是入口点
        slow=n;
        while(true){
            slow=bitSum(slow);
            fast=bitSum(fast);
            if(slow==fast) break;
        }
        if(slow==1) return true;
        return false;
    }

    public static boolean isHappy_ex(int n){
        int slow=n,fast=bitSum(n);
        while(slow!=fast){
            slow=bitSum(slow);
            fast=bitSum(bitSum(fast));
        }
        return slow==1;
    }

    public static void main(String[] args) {
        int n=111;
        System.out.println(bitSum(n));

        System.out.println(isHappy_ex(19));
    }
}
