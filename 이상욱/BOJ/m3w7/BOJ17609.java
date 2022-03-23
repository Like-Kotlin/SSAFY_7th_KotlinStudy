package m3w12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17609 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T; i++) {
			int ans = 2;
			String string = br.readLine();
			
			if(palinDrome(string)) {
				ans = 0;
			}else if(palinDrome2(string)) {
				ans = 1;
			}
			
			System.out.println(ans);
		}
		
	}

	private static boolean palinDrome(String string) {
		int start = 0;
		int end = string.length()-1;
		
		while(start <= end) {
			if(string.charAt(start) != string.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	private static boolean palinDrome2(String string) {
		int start = 0;
		int end = string.length()-1;
		
		while(start <= end) {
			if(string.charAt(start) != string.charAt(end)) {
				
				boolean res = palinDrome(string.substring(start+1,end+1));
				boolean res1 = palinDrome(string.substring(start,end));
				
				return res || res1 ;
				
			}
			start++;
			end--;
		}
		
		return true;
	}

	
}
