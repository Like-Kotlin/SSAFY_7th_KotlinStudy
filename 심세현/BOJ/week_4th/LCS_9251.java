package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
    static char[] A;
    static char[] B;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        DP = new int[A.length + 1][B.length + 1];

        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1] == B[j-1]) DP[i][j] = DP[i-1][j-1] + 1;
                else DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
            }
        }

        System.out.println(DP[A.length][B.length]);
    }


}
