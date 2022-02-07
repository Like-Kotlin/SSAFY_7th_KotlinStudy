package beckjoon.dp;

import java.util.Scanner;

public class Fibonacci_1003 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            arr = new int[n+1][2];
            arr[0][0] = 1; arr[0][1] = 0;
            if(n > 0)  {
                arr[1][0] = 0;
                arr[1][1] = 1;
                Fibo(n);
            }
            System.out.println(arr[n][0]+ " " + arr[n][1]);
        }
    }

    static void Fibo(int n){
        for(int i=2; i<=n; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
            arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
        }
    }
}
