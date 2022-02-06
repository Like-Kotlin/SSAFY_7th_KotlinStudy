
package beckjoon.function;
import java.util.Scanner;

public class Function1065 {
    public static void main(String[] args) {
        boolean[] HanSu = new boolean[1001];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        HanSu[1000] = false;
        for(int i=1; i<100; i++){ HanSu[i] = true; }
        for(int i=100; i<1000; i++){
            HanSu[i] = seperate(i);
        }

        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(HanSu[i] == true){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean seperate(int i) {
        int first = i / 100;
        int second = (i % 100) / 10;
        int last = i % 10;

        if(first - second == second - last){
            return true;
        } else {
            return false;
        }
    }
}

