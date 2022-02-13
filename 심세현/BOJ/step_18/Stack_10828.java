package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){ sb.append(br.readLine() + " "); }
        StringTokenizer sk = new StringTokenizer(sb.toString());
        while(sk.hasMoreTokens()){
            String s = sk.nextToken();
            switch (s){
                case "push":
                    st.push(Integer.valueOf(sk.nextToken()));
                    break;
                case "pop":
                    if(st.isEmpty()){ System.out.println(-1); }
                    else{ System.out.println(st.pop()); }
                    break;
                case "size": System.out.println( st.size() );
                    break;
                case "empty":
                    if(st.isEmpty()){ System.out.println(1); }
                    else{ System.out.println(0); }
                    break;
                case "top":
                    if(st.isEmpty()){ System.out.println(-1); }
                    else{ System.out.println(st.peek()); }
                    break;
                default:
                    break;
            }
        }

    }
}
