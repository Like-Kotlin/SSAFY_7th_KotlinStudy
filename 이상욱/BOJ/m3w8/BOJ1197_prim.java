package m3w8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197_prim {
	static int V,E;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		System.out.println(prim());
		
	}
	private static Long prim() {
		
		boolean[] visit = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(1,0));
		
		long res = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			if(visit[node.d]) {
				continue;
			}
			
			res += node.w;
			visit[node.d] = true;
			cnt++;
			if( cnt == V ) {
				return res;
			}
			
			for(int i = 0; i < list[node.d].size();i++) {
				Node nextNode = list[node.d].get(i);
				if(visit[nextNode.d]) {
					continue;
				}
				
				pq.offer(nextNode);
			}
		}
		
		return res;
	}
}

class Node implements Comparable<Node>{
	int d;
	int w;
	public Node(int d, int w) {
		
		this.d = d;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		
		return this.w - o.w;
	}
	
	
}
