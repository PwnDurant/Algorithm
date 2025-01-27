package 双指针;



public class Max_container {
    public static int maxArea(int[] height) {
        int left=0,right=height.length-1,ret=0;
        while(left<right){
            int ht=Math.min(height[right],height[left]);
            int val=(right-left)*ht;
//            这段代码很重要，直接避免了放在一个数组中然后去单独进行寻找最大值
            ret=Math.max(ret,val);
            if(height[right]==ht) right--;
            else left++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
