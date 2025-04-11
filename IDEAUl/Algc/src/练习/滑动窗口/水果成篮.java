package 练习.滑动窗口;

public class 水果成篮 {
    public static int totalFruit(int[] fruits){
        int kinds=0,ret=0;
        int[] hash=new int[fruits.length];
        for(int left=0,right=0;right<fruits.length;right++){
            int in=fruits[right];
            if(hash[in]==0) kinds++;
            hash[in]++;
            while(kinds>2){
                int out=fruits[left];
                hash[out]--;
                if(hash[out]==0) kinds--;
                left++;
            }
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1};
        System.out.println(totalFruit(nums));
    }
}
