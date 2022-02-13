package m2w7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			
			hs.add(br.readLine());
			
		}
		
		for(int i = 0; i < m; i++) {
			
			String str = br.readLine();
			
			if(hs.contains(str)) {
				ans++;
			}
			
		}
		
		System.out.println(ans);
		
	}
}
