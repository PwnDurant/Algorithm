package 分治;

import java.util.Random;

public class 快速排序 {

    public static int[] sortArray(int[] nums) {
        qsortNums(nums,0, nums.length-1);
        return nums;
    }

    private static void qsortNums(int[] nums, int l, int r) {
        if(l>=r) return ;
        int key=nums[new Random().nextInt(r-l+1)+l];
        int left=l-1,right=r+1,i=l;
        while(i<right){
            if(nums[i]<key) swap(nums,++left,i++);
            else if (nums[i]==key) i++;
            else swap(nums,--right,i);
        }
        qsortNums(nums,l,left);
        qsortNums(nums,right,r);
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp=nums[i];
        nums[i]=nums[i1];
        nums[i1]=tmp;
    }


    public static void main(String[] args) {

    }

}
