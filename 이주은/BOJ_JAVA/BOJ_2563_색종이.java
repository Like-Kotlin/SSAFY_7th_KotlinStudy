import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[101][101];
		int cnt = 0;

		int n = Integer.parseInt(br.readLine());
		for(int t = 0; t < n; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++){
				for(int j = y; j < y + 10; j++){
					if(map[i][j] == 0){
						cnt++;
						map[i][j] = 1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
