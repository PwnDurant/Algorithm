package 二分;

public class findMin {
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
        int[] nums={3,4,5,1,2};
        System.out.println(findMin(nums));


    }
}
