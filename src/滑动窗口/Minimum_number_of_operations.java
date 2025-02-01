package 滑动窗口;









public class Minimum_number_of_operations {

//    public static int sum(int[] nums){
//        int sum=0;
//        for(int num:nums){
//            sum+=num;
//        }
//        return sum;
//    }
    public static int minOperations_ex(int[] nums,int x){
//        这是目标数
        int tmp=0;
//        少开辟一个函数可以降低时间复杂度
        for(int num:nums) tmp+=num;
        int target=tmp-x;
        if(target<0){
            return -1;
        }
        int sum=0;
        int len=-1;
        for(int left=0,right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target){
                len=Math.max(len,right-left+1);
            }

        }
        return len==-1?-1:nums.length-len;
    }











    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(minOperations_ex(nums,3));
    }










    public static int minOperations(int[] nums, int x) {
        int sum=0;
        for(int a:nums) sum+=a;
        int target =sum-x;
        if(target<0) return -1;
        int ret=-1;
        for(int left=0,right=0,tmp=0;right<nums.length;right++){
            tmp+=nums[right];
            while(tmp>target){
                tmp-=nums[left++];
            }
            if(tmp==target) ret=Math.max(ret,right-left+1);
        }
        if(ret==-1) return ret;
        else return nums.length-ret;

    }
}
