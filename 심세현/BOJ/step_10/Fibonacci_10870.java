package beckjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci_10870 {
    static BigInteger[] memo;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new BigInteger[n+1];
        Arrays.fill(memo, BigInteger.ZERO);
        if(n != 0) {
            memo[1] = BigInteger.ONE;
            if(n != 1) memo[2] = BigInteger.ONE;
        }

        System.out.println( fibo(n) );
    }

    static BigInteger fibo(int n){
        if(n > 2 && memo[n].equals(BigInteger.ZERO)){
            memo[n] = fibo(n-1).add(fibo(n-2));
        }
        return memo[n];
    }
}