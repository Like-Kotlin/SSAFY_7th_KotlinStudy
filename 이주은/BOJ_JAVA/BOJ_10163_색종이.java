import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];

		for(int i = 1; i <= n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for(int xx = x; xx < x + w; xx++){
				for(int yy = y; yy < y + h; yy++){
					map[xx][yy] = i;
				}
			}
		}

		for(int i = 1; i <= n; i++){
			int cnt = 0;
			for(int a = 0; a < 1001; a++){
				for(int b = 0; b < 1001; b++){
					if(map[a][b] == i)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
