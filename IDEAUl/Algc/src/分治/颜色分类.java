package 分治;

public class 颜色分类 {

    public static void swap(int a,int b,int[] nums){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }

    public static void sortColors(int[] nums) {

        int left=-1,right=nums.length,i=0;
        while(i<right){
            if(nums[i]==0){
                swap(++left,i++,nums);
            } else if (nums[i]==1) {
                i++;
            }else{
                swap(--right,i,nums);
            }
        }

    }

    public static void main(String[] args) {

        int[] nums={1,2};
        swap(0,1,nums);
        for(int a:nums){
            System.out.println(a);
        }

        int[] num={1,2,0};
        sortColors(num);
        for(int a:num){
            System.out.println(a);
        }

    }
}
