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


    public static void main(String[] args) {
        int[] arr={0,0,0};
        Duplicate_zero duplicateZero=new Duplicate_zero();
        duplicateZero.duplicateZeros(arr);
        System.out.println(arr.toString());
    }
}
