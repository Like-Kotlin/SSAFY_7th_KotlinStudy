package m2w7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= n; i++) {
			
			arr.add(new ArrayList<Integer>());
			
		}
		
		for(int i = 0; i < n-1; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			arr.get(first).add(second);
			arr.get(second).add(first);
			
		}
		
		boolean[] visit = new boolean[n+1];
		int[] result = new int[n+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			
			int num = q.poll();
			
			for(int i = 0; i < arr.get(num).size(); i++) {
				
				if(!visit[arr.get(num).get(i)]) {
					visit[arr.get(num).get(i)] = true;
					result[arr.get(num).get(i)] = num;
					q.add(arr.get(num).get(i));
					
				}
				
			}
				
		}
		
		for(int i = 2; i < arr.size(); i++) {
			
			System.out.println(result[i]);
			
		}
		
		
		
	}
}
