package 练习.二分;

public class 复写零 {

    public static void duplicateZeros(int[] arr) {
//        先找出最后一个元素的位置
        int count=0,det=0;
        while(count<arr.length){
            if(arr[det++]==0) count+=2;
            else count++;
        }
//        此时det指向的位置就是复写过后数组最后一个元素的位置
        int cur=det-1,dest=arr.length-1;
//        判断一下特殊情况
        if(count>arr.length){
            arr[dest--]=0;
            cur--;
        }
//        开始遍历数组
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
        int[] num={0,1,7,6,0,2,0,7};
        duplicateZeros(num);
        for (int a : num){
            System.out.print(a+",");
        }
    }
}
