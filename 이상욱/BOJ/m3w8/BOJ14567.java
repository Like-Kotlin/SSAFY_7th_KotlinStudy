package m3w8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14567 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		int[] memo = new int[N+1];
		Arrays.fill(memo, -1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			boolean check = false;
			for(int j = 1; j <= N; j++) {
				if(map[j][i] == 1) {
					check = true;
					break;
				}
			}
			if(!check) {
				memo[i] = 1;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 1) {
					memo[j] = Math.max(memo[j], memo[i]+1);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			sb.append(memo[i]+" ");
		}
		System.out.println(sb.toString());
		
	}
}
