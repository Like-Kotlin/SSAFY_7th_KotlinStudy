import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int[][] map = new int[6][2];

		int idx_w = 0;
		int idx_h = 0;
		int max_w = 0;
		int max_h = 0;

		for(int i = 0; i < 6; i++) {
			String[] tmp = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(tmp[0]);
			map[i][1] = Integer.parseInt(tmp[1]);
		}

		for(int i = 0; i < 6; i++){
			if(map[i][0] == 1 || map[i][0] == 2){
				if(max_w < map[i][1]){
					max_w = map[i][1];
					idx_w = i;
				}
			}

			else if(map[i][0] == 3 || map[i][0] == 4){
				if(max_h < map[i][1]){
					max_h = map[i][1];
					idx_h = i;
				}
			}
		}

		int h = 0;
		int w = 0;

		if(idx_h == 0)
			h = Math.abs(map[5][1] - map[1][1]);
		else if(idx_h == 5)
			h = Math.abs(map[4][1] - map[0][1]);
		else
			h = Math.abs(map[idx_h - 1][1] - map[idx_h + 1][1]);

		if(idx_w == 0)
			w = Math.abs(map[5][1] - map[1][1]);
		else if(idx_w == 5)
			w = Math.abs(map[4][1] - map[0][1]);
		else
			w = Math.abs(map[idx_w - 1][1] - map[idx_w + 1][1]);

		System.out.println((max_w * max_h - h * w) * k);
	}
}
