package m3w11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22871 {
	static int N;
	static long[] arr;
	static long[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N]; 
		dp = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			dp[i] = -1;
		}
		
		System.out.println(cross(0));
		
	}
	private static long cross(int x) {
		
		if( x == N-1 ) {
			return 0;
		}
		
		if(dp[x] != -1) {
			return dp[x];
		}
		
		dp[x] = Long.MAX_VALUE;
		
		for(int i  = x+1; i < N; i++) {
			dp[x] = Math.min(dp[x], Math.max(cross(i), (i-x) * (1 + Math.abs(arr[x] - arr[i]))));
		}
		
		return dp[x];
	}
}
