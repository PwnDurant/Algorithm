package 双指针;

public class Two_number_sum {
    public static int[] twoSum(int[] price, int target) {
        int min=0,max=price.length-1;
        while(min<max){
            if(price[min]+price[max]>target){
                max--;
                continue;
            }
            if(price[min]+price[max]<target){
                min++;
            }else{
                break;
            }
        }
        int[] ret={price[min],price[max]};
        return ret;
    }


    public static int[] twoSum_ex(int[] price, int target){
        int left=0,right=price.length-1;
        while(left<right){
            int sum=price[left]+price[right];
            if(sum>target) right--;
            else if(sum<target) left++;
            else return new int[] {price[left],price[right]};
        }
        return new int[] {0};
    }

    public static void main(String[] args) {
        int[] price={8, 21, 27, 34, 52, 66};
        int[] ret=twoSum_ex(price,61);
        for(int r:ret){
            System.out.println(r);
        }
    }
}
