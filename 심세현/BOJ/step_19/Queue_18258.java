package beckjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String s = br.readLine();
            sb.append(s+"\n");
        }

        StringTokenizer st = new StringTokenizer(sb.toString());
        sb = new StringBuilder();
        int last = -1;
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            switch (s){
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    q.add(last);
                    break;
                case "front":
                    if(q.isEmpty()){ sb.append(-1+"\n"); }
                    else { sb.append(q.peek()+"\n"); }
                    break;
                case "back":
                    if(q.isEmpty()){ sb.append(-1+"\n"); }
                    else { sb.append(last+"\n"); }
                    break;
                case "size": sb.append(q.size()+"\n");;
                    break;
                case "empty":
                    if(q.isEmpty()){ sb.append(1+"\n");; }
                    else { sb.append(0+"\n");; }
                    break;
                case "pop":
                    if(q.isEmpty()){ sb.append(-1+"\n"); }
                    else { sb.append(q.poll()+"\n"); }
                    break;
            }
        }
        System.out.print(sb);
    }
}
