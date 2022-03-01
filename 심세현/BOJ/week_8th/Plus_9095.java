package beckjoon.dp;

import java.util.Scanner;

public class Plus_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] DP = new int[11];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for(int tc=0; tc<T; tc++){
            int n = sc.nextInt();
            if(n > 3){
                for(int i=4; i<=n; i++){
                    DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
                }
            }
            System.out.println(DP[n]);
        }
    }
}
