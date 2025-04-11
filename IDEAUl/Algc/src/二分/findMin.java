package 二分;

public class findMin {

    public static int findMin_ex(int[] nums){
        int tmp=nums[nums.length-1];
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>tmp) left=mid+1;
            else right=mid;
        }
        return nums[left];
    }


    public static int findMin_ex_left(int[] nums){
        int tmp=nums[0];
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>tmp) left=mid+1;
            else right=mid;
        }
        return nums[left];
    }









    public static int findMin(int[] nums) {
        int left=0,right= nums.length-1;
        int x=nums[right];
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>x) left=mid+1;
            else right=mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums={11,13,15,17};
        System.out.println(findMin_ex_left(nums));


    }
}
