package 二分;

public  class Square_root_of_x {
    public static int mySqrt(int x){
        if(x<1) return 0;
        long left=1,right=x;
        while(left<right){
            long mid=left+(right-left+1)/2;
            if(mid*mid<=x) left=mid;
            else right=mid-1;
        }
        return (int)left;
    }

    public static void main(String[] args) {
        int x=4;
        System.out.println(mySqrt(x));
    }
}
