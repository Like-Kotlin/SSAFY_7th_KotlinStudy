import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            nodes[i] = new Node(start, end);
        }

        Arrays.sort(nodes);

        int cnt = 0;
        int prevEnd = 0;
        for (int i = 0; i < N; i++) {
            Node curNode = nodes[i];
            if (prevEnd <= curNode.start) {
                prevEnd = curNode.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Node implements Comparable<Node> {
    int start, end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        System.out.println("this.start : " + this.start + ", o.start : " + o.start);
        return o.end == this.end ? this.start - o.start : this.end - o.end;
    }
}