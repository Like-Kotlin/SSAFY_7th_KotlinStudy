package m3w11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1174 {
	
	static ArrayList<Long> list = new ArrayList<>();
	static int[] num = {9,8,7,6,5,4,3,2,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dfs(0L,0);
		Collections.sort(list);
		
		if(N > 1023) {
			System.out.println(-1);
		}else {
			System.out.println(list.get(N-1));
		}
		
	}

	private static void dfs(Long res, int i) {
		
		if(!list.contains(res)) {
			list.add(res);
		}
		
		if( i >= 10) {
			return;
		}
		
		dfs(res*10 + num[i], i+1);
		dfs(res, i+1);
	}
}
