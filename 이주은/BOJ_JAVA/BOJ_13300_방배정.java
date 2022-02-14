import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 0;

		int[][] map = new int[6][2];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[y - 1][s]++;
		}

		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 2; j++){
				if(map[i][j] == 0)
					continue;

				cnt += map[i][j] / k;

				if(map[i][j] % k != 0){
					cnt += 1;
				}
			}
		}

		System.out.println(cnt);
	}
}
