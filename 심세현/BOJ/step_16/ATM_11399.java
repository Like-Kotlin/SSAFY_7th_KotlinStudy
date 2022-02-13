package beckjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] newArr = new int[n];
        for(int i=0; i<n; i++) { arr[i] = sc.nextInt(); }
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            newArr[i] = sum;
        }
        sum = 0;
        for(int i : newArr){ sum += i;}
        System.out.println(sum);
    }
}
