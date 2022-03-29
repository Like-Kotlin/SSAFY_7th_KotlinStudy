package m3w8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197_kruskal {
	static int V,E;
	static int[] p;
	static Node_[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		arr = new Node_[E];
		p = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node_(a,b,c);
		}
		
		System.out.println(kruskal());
	}
	private static int kruskal() {
		
		int res = 0;
		int cnt = 0;
		
		Arrays.sort(arr);
		
		for( Node_ n : arr ) {
			if(union(n.s,n.d)) {
				res += n.w;
				cnt++;
				if(cnt == V-1) {
					return res;
				}
			}
		}
		
		return res;
	}
	private static boolean union(int s, int d) {
	
		int sP = find(s);
		int dP = find(d);
		
		if(sP == dP) {
			return false;
		}
		
		p[sP] = p[dP];
		return true;
	}
	
	
	private static int find(int s) {
		
		if(s == p[s]) {
			return s;
		}
		
		return p[s] = find(p[s]);
				
	}
	
}

class Node_ implements Comparable<Node_>{
	
	int s;
	int d;
	int w;
	
	
	public Node_(int s, int d, int w) {
		this.s = s;
		this.d = d;
		this.w = w;
	}


	@Override
	public int compareTo(Node_ o) {
		
		return this.w - o.w;
	}
	
}
