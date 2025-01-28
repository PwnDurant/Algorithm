package 双指针;

public class Duplicate_zero {
    public void duplicateZeros(int[] arr) {
//        先确定最后一个数是什么
        int count=0,det=0;
        while(count<arr.length){
            if(arr[det++]==0) count+=2;
            else count+=1;
        }
//        循环结束之后，det所指向的下标就是最后一个数字
        int cur=det-1,dest= arr.length-1;
        if(count>arr.length){
            arr[dest]=0;
            dest--;
            cur--;
        }
        while(cur>=0){
            if(arr[cur]==0){
                arr[dest--]=0;
                arr[dest--]=0;
                cur--;
            }else{
                arr[dest--]=arr[cur--];
            }
        }
    }

    public static void duplicateZeros_ex(int[] arr){
//        先找到最后一个需要复写的数
        int cur=0,dest=-1,n=arr.length;
        while(cur<n){
            if(arr[cur]==0) dest+=2;
            else dest+=1;
            if(dest>=n-1) break;
            cur++;
        }
//        处理一下边界情况
        if(dest==n){
            arr[n-1]=0;
            cur--;
            dest-=2;
        }
//        从后往前进行遍历
        while(cur>0){
            if(arr[cur]!=0) arr[dest--]=arr[cur--];
            else{
                arr[dest--]=0;
                arr[dest--]=0;
                cur--;
            }
        }
    }

    public static void print(int[] nums){
        for(int num:nums){
            System.out.print(num+" ");
        }
    }


    public static void main(String[] args) {
        int[] arr={1,2,0,0,4,0,1};
        Duplicate_zero duplicateZero=new Duplicate_zero();
        duplicateZero.duplicateZeros_ex(arr);
        print(arr);
    }
}
