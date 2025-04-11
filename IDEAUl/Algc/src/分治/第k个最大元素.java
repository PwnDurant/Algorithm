package 分治;

import java.util.Random;

public class 第k个最大元素 {

    public static int findKthLargest(int[] nums, int k) {
        return qsort(nums,0,nums.length-1,k);
    }

    private static int qsort(int[] nums, int l, int r, int k) {
        if(l==r) return nums[l];
        int key=nums[new Random().nextInt(r-l+1)+l];
        int left=l-1,right=r+1,i=l;
        while(i<right){
            if(nums[i]<key) swap(nums,++left,i++);
            else if (nums[i]==key)  i++;
            else swap(nums,--right,i);
        }
        int c=r-right+1,b=right-left-1;
        if(c>=k) return qsort(nums,right,r,k);
        else if (c+b>=k)  return key;
        else return qsort(nums,l,left,k-b-c);
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp=nums[i];
        nums[i]=nums[i1];
        nums[i1]=tmp;
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }

}
