package beckjoon.bruteforce;

import java.util.Scanner;

public class Body_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[sc.nextInt()][2];

        for(int i=0; i<arr.length; i++){
            arr[i][0] = sc.nextInt(); // 몸무게
            arr[i][1] = sc.nextInt(); // 키
        }
        StringBuilder sb = new StringBuilder();
        // 무게 비교
        for(int i=0; i<arr.length; i++){
            int cnt = 1;
            for(int j=0; j<arr.length; j++){
                if(arr[i][0] < arr[j][0] &&  arr[i][1] < arr[j][1]) { cnt++; }
            }
            sb.append(cnt + " ");
        }
        System.out.println(sb);
    }
}
