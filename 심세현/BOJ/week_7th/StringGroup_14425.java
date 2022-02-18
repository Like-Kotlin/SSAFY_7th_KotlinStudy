package beckjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class StringGroup_14425 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> tree = new TreeSet<>();

        int cnt = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i=0; i<N; i++){
            tree.add(sc.next());
        }

        for(int i=0; i<M; i++){
            String s = sc.next();
            if(tree.contains(s)) cnt++;
        }
        System.out.println(cnt);
    }
}

