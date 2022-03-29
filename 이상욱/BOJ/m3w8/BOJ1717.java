package m3w8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1717 {
	
	static int[] p;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(first == 0) {
				union(num1,num2);
			}else {
				if(findParent(num1) == findParent(num2)) {
					sb.append("YES"+"\n");
				}else {
					sb.append("NO"+"\n");
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
		
		
		
	}
	
	private static int findParent(int x) {
		if(x == p[x]) {
			return x;
		}
		
		return p[x] = findParent(p[x]);
	}

	private static void union(int num1, int num2) {
		
		int x = findParent(num1);
		int y = findParent(num2);
		
		if(x != y) {
			if(x < y) {
				p[y] = x;
			}else {
				p[x] = y;
			}
		}
		
	}
}
