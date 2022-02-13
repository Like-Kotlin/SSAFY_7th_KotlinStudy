package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math__1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i=0; i<N; i++){
            int cnt = 0;
            int n = Integer.parseInt(st.nextToken());
            for(int j=1; j<=n; j++){ if(n%j == 0) cnt++; }
            if(cnt == 2) total++;
        }
        System.out.println(total);
    }
}
