package beckjoon.recursion;

import java.util.Scanner;

public class Factorial_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(getFactorial(N));
    }
    static int getFactorial(int n){
        if(n > 2){ n = n * getFactorial(n-1 ); }
        if(n == 0){ return 1; }
        return n;
    }
}
