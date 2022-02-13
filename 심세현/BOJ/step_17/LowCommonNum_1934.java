package beckjoon.numberncomb;

import java.util.Scanner;

public class LowCommonNum_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        int T = sc.nextInt();
        for(int i=1; i<=T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(lcm(a, b));
        }
    }
    static int lcm(int a, int b){
        int i = 1;
        int c;
        if(a == b){ return a; }
        else if(a > b){
            while(true){
                c = a * i;
                if(c % b == 0){ return c; }
                i++;
            }
        }
        else {
            while(true){
                c = b * i;
                if(c % a == 0){ return c; }
                i++;
            }
        }
    }
}
