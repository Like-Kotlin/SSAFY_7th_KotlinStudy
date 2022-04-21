package m4w11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922 {
	
	static int max = -1;
	static int n,k;
	static int[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int len = 0;
		
		while(end != n) {
			if(visit[arr[end]] < k) {
				visit[arr[end]]++;
				end++;
				len++;
				max = Math.max(max, len);
			}else {
				visit[arr[start]]--;
				start++;
				len--;
			}
		}
		
		System.out.println(max);
	}
}
