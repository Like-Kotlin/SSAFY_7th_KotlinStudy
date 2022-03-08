package m2w10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static int n, L, R;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
	
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		
		while(true) {
			if(makeRoad()) {
				day++;
			}else {
				break;
			}
		}
		
		System.out.println(day);
	}

	private static boolean makeRoad() {
		
		visit = new boolean[n][n];
		
		boolean check = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					if(bfs(i,j)) {
						check = true;
					}
				}
			}
		}
		
		if(!check) {
			return false;
		}
		
		return true;
	}

	private static boolean bfs(int x, int y) {
		
		visit[x][y] = true;
		int sum = map[x][y];
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		list.clear();
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];
			
			for(int i =0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if(!visit[nx][ny] && Math.abs(map[cx][cy] - map[nx][ny]) >= L && Math.abs(map[cx][cy] - map[nx][ny]) <= R) {
						visit[nx][ny] = true;
						q.offer(new int[] {nx,ny});
						list.add(new int[] {nx,ny});
						sum += map[nx][ny];
						cnt++;
					}
				}
			}
		}
		if(sum == map[x][y]) {
			return false;
		}
		
		list.add(new int[] {x,y});
		int avg = sum / cnt;
		move(avg);
		return true;
		
	}

	private static void move(int people) {

		for(int i = 0; i< list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]] = people;
		}
	}
}
