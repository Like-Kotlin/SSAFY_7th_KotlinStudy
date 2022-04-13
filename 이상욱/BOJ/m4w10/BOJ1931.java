package m4w10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(map,new Comparator<int[]>() {
			
			@Override
			public int compare(int[] arr1, int[] arr2) {
				
				if(arr1[1] == arr2[1]) {
					return arr1[0] - arr2[0];
				}

				return arr1[1] - arr2[1];
			}
		});
		
		int cnt = 0;
		int end = 0;
		
		for(int i = 0; i < map.length; i++) {
			
			if(end <= map[i][0]) {
				end = map[i][1];
				cnt++;
			}
			
		}
		System.out.println(cnt);
		
	}
}
