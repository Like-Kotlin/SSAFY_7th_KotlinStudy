package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog_21921 {
    static int[] visit;
    static int N, X;
    static int MAX, cnt, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visit = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            visit[i] = Integer.parseInt(st.nextToken());
            if(i < X) sum += visit[i];
        }
        MAX = sum;
        cnt = 1;
        getMax();

        if(MAX == 0){
            System.out.println("SAD"); return;
        }
        System.out.println(MAX);
        System.out.println(cnt);
    }

    static void getMax(){
        int st = 0;
        int end = X;
        while(st != N-X && end != N){
            sum -= visit[st++];
            sum += visit[end++];

            if(sum > MAX){ MAX = sum; cnt = 1;}
            else if(sum == MAX){ cnt++; }
        }
    }
}
