package 练习.二分;

public class 盛水最多的容器 {

    public static int maxArea(int[] height) {
        int left=0,right=height.length-1,ret=0;
        while(left<right){
            int h=Math.min(height[right],height[left]);
            int val=h*(right-left);
            ret=Math.max(ret,val);
            if(height[left]==h) left++;
            else right--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}
