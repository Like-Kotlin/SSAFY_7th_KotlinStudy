import java.util.*;
import javax.xml.soap.Node;
import java.io.*;
import java.lang.reflect.Array;

// 1. 시작, 끝 노드를 양측에 가중치와 함께 각각 저장
// 2. 해당 가중치를 weight에 따라 정렬 -> 노드 내에서 
// 3. 1번 노드 부터 시작해서 가장 최소비용으로 움직일 수 있는 노드 찾기
// 4. 움직이기 
public class Solution {
    static int V, E;
    static ArrayList<Node>[] arr;

    public static class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, value));
            arr[end].add(new Node(start, value));
        }

        System.out.println(prim());
    }

    public static int prim() {
        int ans = 0;
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0)); // 시작 노드

        // 최솟값 찾기
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();

            // 이미 방문한 노드면 패스
            if (visited[n.to]) {
                continue;
            }
            ans += n.weight;
            visited[n.to] = true;
            cnt++;
            if (cnt == V) {
                break;
            }

            // 사이즈 만큼 돌기
            for (int i = 0; i < arr[n.to].size(); i++) {
                Node next = arr[n.to].get(i);
                if (visited[next.to])
                    continue;
                // 방문하면
                pq.add(next);
            }
        }
        return ans;
    }
}
