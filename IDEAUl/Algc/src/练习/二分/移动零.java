package 练习.二分;

public class 移动零 {

    public static void swap(int a,int b,int[] nums){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }

    public static void moveZeroes(int[] nums) {

        int cur=0,dest=-1;
        int length=nums.length;
        while (cur<length){
            if(nums[cur]==0){
                cur++;
            }else{
                dest++;
                swap(cur,dest,nums);
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num={0,1,0,3,12};
        moveZeroes(num);
        for (int a : num){
            System.out.print(a+",");
        }
    }

}
