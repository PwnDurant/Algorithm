package 二分;

public class Search_insertion_position {
    public static int searchInsert_ex(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else right=mid;
        }
        if(nums[left]<target) return left+1;
        return left;
    }










    public static int searchInsert(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else right=mid;
        }

        if(nums[right]<target) return right+1;
        return right;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=5;
        System.out.println(searchInsert(nums,target));
    }
}
