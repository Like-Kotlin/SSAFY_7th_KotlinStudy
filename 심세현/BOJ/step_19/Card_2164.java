package beckjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = sc.nextInt();
        if(N == 1){ System.out.println(1); return; }
        for(int i=1; i<=N; i++){ q.add(i); }

        q.poll();
        while(q.size() > 1){
            int a = q.poll();
            q.add(a);
            q.poll();
        }
        System.out.println(q.peek());
    }
}
