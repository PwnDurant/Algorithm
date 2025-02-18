package 二分;

public class Mountain_array_peak_index {
    public static int peakIndexInMountainArray_ex(int[] arr){
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<arr[mid+1]) left=mid+1;
            else right=mid;
        }
        return left;
    }












    public static int peakIndexInMountainArray(int[] arr) {
        int left=1,right=arr.length-2;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(arr[mid]>arr[mid-1]) left=mid;
            else right=mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr={0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}

