package 练习.二分;

import java.util.ArrayList;
import java.util.Arrays;

public class 查找总价格为目标值的两个商品 {

    public static int[] twoSum(int[] price, int target) {
        int min=0,max=price.length-1;
        while(min<max){
            if(price[min]+price[max]>target) max--;
            else if (price[min]+price[max]<target) {
                min++;
            }else{
                break;
            }
        }
        int[] ret={price[min],price[max]};
        return ret;
    }

    public static void main(String[] args) {
        int[] price={3, 9, 12, 15};
        int target=18;
        int[] ret=twoSum(price,target);
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(ret[0]);
        arrayList.add(ret[1]);
        System.out.println(arrayList);
    }
}
