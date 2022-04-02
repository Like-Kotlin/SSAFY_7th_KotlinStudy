package m4w9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15681 {

	static ArrayList<Integer>[] list, tree;
	static int p[], size[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		p = new int[n + 1];
		size = new int[n + 1];
		list = new ArrayList[n + 1];
		tree = new ArrayList[n + 1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		makeTree(r, -1);
		countSubtreeNodes(r);
		
		
		StringBuffer sb = new StringBuffer();
		while (q-- > 0) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	public static void makeTree(int currentNode, int parent) {
		
		for (int node : list[currentNode]) {
			
			if (node != parent) {
				tree[currentNode].add(node);
				p[node] = currentNode;
				makeTree(node, currentNode);
			}
		}
	}

	
	public static void countSubtreeNodes(int currentNode) {
		
		size[currentNode] = 1;
		
		for (int node : tree[currentNode]) {
			countSubtreeNodes(node);
			size[currentNode] += size[node];
		}
	}

}
