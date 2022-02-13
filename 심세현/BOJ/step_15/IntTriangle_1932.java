package beckjoon.dp;

import java.util.Scanner;

public class IntTriangle_1932 {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        arr = new int[T][T];
        dp = new int[T][T];
        for(int i=0; i<T; i++){
            for(int j=0; j<=i; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<T; i++){ dp[T-1][i] = arr[T-1][i]; }
        // dp 배열에 값 채워넣기
        for(int i=T-2; i>=0; i--) {
            for(int j=0; j<=i; j++){
                int sum = arr[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
                dp[i][j] = sum;
            }
        }
        System.out.println(dp[0][0]);
    }
}
