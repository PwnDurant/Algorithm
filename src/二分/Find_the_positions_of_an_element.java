package 二分;

public class Find_the_positions_of_an_element {



    public static int[] searchRange_ex(int[] nums,int target){

        int[] ret={-1,-1};
        if (nums.length==0) return ret;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else right=mid;
        }
        if(nums[left]==target) ret[0]=left;
        right=nums.length-1;
        while(left<right){
            int mid=left+(right-left+ 1)/2;
            if(nums[mid]<=target) left=mid;
            else right=mid-1;
        }
        if(nums[right]==target) ret[1]=right;

        return ret;
    }















    public static int[] searchRange(int[] nums, int target) {
        int[] ret={-1,-1};
        if(nums.length==0) return ret;

        int left=0,right= nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else right=mid;
        }
        if(nums[left]!=target) return ret;
        ret[0]=right;

        right=nums.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]<=target) left=mid;
            else right=mid-1;
        }
        ret[1]=left;
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=6;
        int[] tmp=searchRange_ex(nums,target);
        for(int t:tmp) System.out.println(t);
    }
}
