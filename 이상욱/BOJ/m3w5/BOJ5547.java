package m2w10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5547 {
	
	static int col,row;
	static int[][] map;
	static boolean[][] outside;
	static int[] oddDx = {-1,0,1,1,0,-1};
	static int[] oddDy = {0,-1,0,1,1,1};
	static int[] evenDx = {-1,0,1,1,0,-1};
	static int[] evenDy = {-1,-1,-1,0,1,0};
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row+2][col+2];
		outside = new boolean[row+2][col+2];
		
		for(int i = 1; i < row+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < col+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q = new LinkedList<>();
		
		q.offer(new int[]{0,0});
		outside[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int cx = arr[0];
			int cy = arr[1];
			for(int i =0; i < 6; i++) {
				if( cx % 2 == 0) {
					checkOut(evenDx, evenDy, cx, cy, i);
				}else {
					checkOut(oddDx,oddDy, cx, cy, i);
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i < row+1; i++) {
			for(int j = 1; j < col+1;j++ ) {
				if(map[i][j] == 0 ) {
					continue;
				}
				for(int k = 0; k < 6; k++) {
					int nx = 0;
					int ny = 0;
					if(i%2 == 0) {
						nx = i + evenDx[k];
						ny = j + evenDy[k];
					}else {
						nx = i + oddDx[k];
						ny = j + oddDy[k];
					}
					
					if(outside[nx][ny]) {
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
	private static void checkOut(int[] dx, int[] dy, int cx, int cy, int i) {
		int nx = cx + dx[i];
		int ny = cy + dy[i];
		if(nx >= 0 && nx <= row+1 && ny >= 0 && ny <= col+1) {
			if(!outside[nx][ny]) {
				if(map[nx][ny] == 0) {
					outside[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		
	}
}
