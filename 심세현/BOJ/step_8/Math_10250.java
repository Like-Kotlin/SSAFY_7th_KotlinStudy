
package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            String str = br.readLine();
            sb.append(str+" ");
        }
        st = new StringTokenizer(sb.toString());
        for(int i=0; i<T; i++){
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            String room = "01";
            int num = 1;
            if(N <= H) {System.out.println(N+room); continue;}
            while (N > H){
                N -= H;
                num += 1;
            }
            if(num < 10){ room = "0"+num; System.out.println(N+room); }
            else { System.out.println(N+""+num); }
        }
    }
}
