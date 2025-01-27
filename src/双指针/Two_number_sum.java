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

    public static void main(String[] args) {
        int[] price={8, 21, 27, 34, 52, 66};
        int[] ret=twoSum(price,61);
        for(int r:ret){
            System.out.println(r);
        }
    }
}
