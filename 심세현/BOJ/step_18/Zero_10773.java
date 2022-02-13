package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.equals("0")){ st.pop(); }
            else{ st.push(Integer.valueOf(s)); }
        }
        int sum = 0;
        while(!st.isEmpty()){ sum += st.pop(); }
        System.out.println(sum);
    }
}
