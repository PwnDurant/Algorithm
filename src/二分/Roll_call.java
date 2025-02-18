package 二分;

import java.util.HashMap;
import java.util.HashSet;

public class Roll_call {

//    public static int takeAttendance_ex(int[] records){
//        HashMap<Integer,Integer> hashMap=new HashMap<>();
//        int i=0,result=0;
//        for(int tmp:records){
//            hashMap.put(i, tmp);
//            i++;
//        }
//        for(int j=0;j<records.length;j++){
//            if(hashMap.get(j)!=j) result=j;
//        }
//        return result;
//    }


    public static int takeAttendance_ex(int[] records){
        HashSet<Integer> set=new HashSet<>();
        for(int num:records) set.add(num);
        for(int i=0;i<= records.length;i++)
            if(!set.contains(i)) return i;
        return -1;
    }



    public static  int takeAttendance(int[] records) {
        int left=0,right=records.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(records[mid]==mid) left=mid+1;
            else right=mid;
        }
        return records[left]==left?left+1:left;
    }

    public static void main(String[] args) {
        int[] records={0};
        System.out.println(takeAttendance(records));
    }


}
