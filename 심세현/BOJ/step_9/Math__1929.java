package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Math__1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];

        for(int i=2; i<=N; i++){
            if(!arr[i]){ for(int j=2; i*j<=N; j++) { arr[i*j] = true; } }
        }
        for(int i=M; i<=N; i++){ if(!arr[i] && i>1) sb.append(i+"\n"); }
        System.out.println(sb);
    }
}
