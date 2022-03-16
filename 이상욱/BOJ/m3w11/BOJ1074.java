package m3w11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ1074 {
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int mapSize = (int) Math.pow(2, N);
		answer = 0;
		
		checkZ(mapSize, r, c);
		System.out.println(answer);
	}
	private static void checkZ(int mapSize, int r, int c) {
		
		if(mapSize == 1)
			return;
		
		if(r < mapSize/2 && c < mapSize/2) {
			checkZ(mapSize/2, r, c);
		}
		else if(r < mapSize/2 && c >= mapSize/2) {
			answer += mapSize * mapSize / 4;
			checkZ(mapSize/2, r, c - mapSize/2);
		}
		else if(r >= mapSize/2 && c < mapSize/2) {
			answer += (mapSize * mapSize / 4) * 2;
			checkZ(mapSize/2, r - mapSize/2, c);
		}
		else {
			answer += (mapSize * mapSize / 4) * 3;
			checkZ(mapSize/2, r - mapSize/2, c - mapSize/2);
		}
		
	}
}
