package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Cnt{
	int zero;
	int one;
	
	public Cnt(int zero, int one) {
		this.zero = zero;
		this.one = one;
	}
    
	public int getZero() {
		return zero;
	}

	public int getOne() {
		return one;
	}

	@Override
	public String toString() {
		
		return this.zero +" "+this.one;
	}
}

public class BOJ1003 {
	
	static Cnt[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			dp = new Cnt[n+1];
			
			dp[0] = new Cnt(1,0);
			
			if( n == 0 ) {
				System.out.println(dp[0]);
			}else {
				dp[1] = new Cnt(0,1);
				if(n==1) {
					System.out.println(dp[n]);
				}else {
					for (int j = 2; j < dp.length; j++) {
						dp[j] = new Cnt(dp[j-2].getZero()+dp[j-1].getZero(),
										dp[j-2].getOne()+dp[j-1].getOne());
						
					}
					
					
					System.out.println(dp[n]);
				}
					
				
				
				
			}

		}
		
		}

}