package 二分;

import java.util.Scanner;

public class Prefix_and_suffix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=scan.nextInt();
        int q=scan.nextInt();
//        为了防止溢出，用long类型的数组
        int[] arr=new int[n+1];
        long[] dp=new long[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=scan.nextInt();
        }
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]+arr[i];
        }
        while(q>0){
            int l=scan.nextInt();
            int r=scan.nextInt();
            System.out.println(dp[r]-dp[l-1]);
            q--;
        }
    }

}
