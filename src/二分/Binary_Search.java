package 二分;

public class Binary_Search {
    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target) right=mid-1;
            else if (nums[mid]<target) left=mid+1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        int target=9;
        System.out.println(search(nums,target));
    }
}
