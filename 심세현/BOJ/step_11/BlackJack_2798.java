package beckjoon.bruteforce;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        int maxNum = sc.nextInt();

        for(int i=0; i<N; i++){ arr[i] = sc.nextInt(); }
        Arrays.sort(arr, Collections.reverseOrder());

        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k=j+1; k<N; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= maxNum && sum > max){
                        max = sum;
                        if(max == maxNum)
                        {
                            System.out.println(max);
                            return;
                        }
                    }
                    else{ continue; }
                }
            }
        }
        System.out.println(max);
    }
}
