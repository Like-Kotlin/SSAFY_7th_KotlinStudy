package beckjoon.backtracking;

import java.util.Scanner;

public class Basic_15650 {
    static int[] arr;
    static int r;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1 ~ N까지 자연수
        r = sc.nextInt(); // 수열의 길이

        arr = new int[r];

        permutation(1, 0);
    }
    static void permutation(int at, int depth) {
       if(depth == r){
           for(int i : arr){ System.out.print(i + " "); }
           System.out.println();
           return;
       }
       for(int i=at; i<=n; i++){
           arr[depth] = i;
           permutation(i+1, depth + 1);
       }
    }
}
