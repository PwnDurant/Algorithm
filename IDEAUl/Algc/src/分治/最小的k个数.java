package 分治;


import java.util.Random;

public class 最小的k个数 {

    public int[] inventoryManagement(int[] stock, int cnt) {
        qsort(stock,0,stock.length-1,cnt);

        int[] ret=new int[cnt];
        for(int i=0;i<cnt;i++){
            ret[i] =stock[i];
        }
        return ret;
    }

    private void qsort(int[] nums, int l, int r, int k) {

        if(l>=r) return ;

        int key=nums[new Random().nextInt(r-l+1)+l];
        int left=l-1,right=r+1,i=l;
        while(i<right){
            if(nums[i]<key) swap(nums,++left,i++);
            else if(nums[i]==key) i++;
            else swap(nums,--right,i);
        }

        int a=left-l+1,b=right-left-1;
        if(a>k) qsort(nums,l,left,k);
        else if(a+b>=k) return;
        else qsort(nums,right,r,k-a-b);

    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp=nums[i];
        nums[i]=nums[i1];
        nums[i1]=tmp;
    }


    public static void main(String[] args) {

    }
}
