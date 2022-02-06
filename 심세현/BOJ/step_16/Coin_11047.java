package beckjoon.greedy;

import java.util.Scanner;

public class Coin_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] <= target){
                cnt += target / arr[i];
                target = target % arr[i];
            }
        }
        System.out.println(cnt);
    }
}
