package 二分;

import java.util.Scanner;

public class Two_dimensional_prefix_sum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int q=scanner.nextInt();
        int[][] arr=new int[n+1][m+1];
        long[][] dp=new long[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++)
                arr[i][j]=scanner.nextInt();
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
            }
        }

        while(q>0){
            int x1=scanner.nextInt(),y1=scanner.nextInt(),x2=scanner.nextInt(),y2=scanner.nextInt();
            System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
            q--;
        }
    }
}
