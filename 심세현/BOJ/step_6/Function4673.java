
package beckjoon.function;

import java.util.Arrays;
import java.util.Scanner;

public class Function4673 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();

        boolean[] total = new boolean[10001];
        Arrays.fill(total, false); // 0 ~ 10000까지 폴스

        for(int i = 1; i< total.length; i++){
            int v = d(i);
            if(v < 10001){
                total[v] = true;
            }
        }

        for(int i = 1; i< total.length; i++){
            if(total[i] == false){
                System.out.println(i);
            }
        }
    }

    public static int d(int n){
        int sum = n;

        while(n != 0){
            sum += n % 10;
            n = n /10;
        }

        return sum;
    }

}
