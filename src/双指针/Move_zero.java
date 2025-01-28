package 双指针;

public class Move_zero {
    public void moveZeroes(int[] nums) {
        int cur=0,dest=-1,len=nums.length;
        while(cur<len){
            if(nums[cur]==0){
                cur++;
            }else {
                dest++;
                int tmp = nums[dest];
                nums[dest] = nums[cur];
                nums[cur] = tmp;
                cur++;
            }
            }
    }

//    优化代码
    public static void moveZeroes_ex(int[] nums){
        for(int cur=0,dest=-1;cur< nums.length;cur++){
//            只需要处理非零元素
            if(nums[cur]!=0){
//                dest先向后移动一位
                dest++;
                int tmp=nums[cur];
                nums[cur]=nums[dest];
                nums[dest]=tmp;
            }
        }
    }

    public static void print(int[] nums){
        for(int num:nums){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        int[] test={1,2,0,0,3,9};
        moveZeroes_ex(test);
        print(test);
    }
}
