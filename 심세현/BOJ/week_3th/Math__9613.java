
package beckjoon.math;

import java.util.Arrays;
import java.util.Scanner;

public class Math__9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int N = sc.nextInt();
            int[] num = new int[N];

            for(int i=0; i<N; i++){ num[i] = sc.nextInt(); }
            Arrays.sort(num);

            long ans = 0;
            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    ans += GCD(num[j], num[i]);
                }
            }
            System.out.println(ans);
        }
    }

    static int GCD(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
