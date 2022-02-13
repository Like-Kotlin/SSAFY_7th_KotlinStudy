package beckjoon.backtracking;

import java.util.Scanner;

public class Basic_15649 {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1 ~ N까지 자연수
        int r = sc.nextInt(); // 수열의 길이

        arr = new int[r];
        visited = new boolean[n];

        permutation(n, r, 0);
    }
    static void permutation(int n, int r, int depth) {
       if(depth == r){
           for(int i : arr){ System.out.print(i + " "); }
           System.out.println();
           return;
       }

       for(int i=0; i<n; i++){
           if(!visited[i]){
               visited[i] = true;
               arr[depth] = i + 1;
               permutation(n, r, depth + 1);
               visited[i] = false;
           }

       }
    }


}
