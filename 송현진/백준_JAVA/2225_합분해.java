import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ans = new int[201][201];

        for (int i = 0; i < 201; i++) {
            //0개 사용, i 합
            ans[i][0] = 1;
            ans[1][i] = 1;
        }
        for (int i = 1; i < 201; i++) {
            ans[2][i] = i + 1;
        }
        for (int i = 3; i < 201; i++) {
            for (int j = 1; j < 201; j++) {
                for (int k = 0; k <= j; k++) {
                    ans[i][j] = ans[i - 1][j - k] % 1000000000;
                }
            }
        }
        System.out.println(ans[M][N] % 1000000000);
    }

}
