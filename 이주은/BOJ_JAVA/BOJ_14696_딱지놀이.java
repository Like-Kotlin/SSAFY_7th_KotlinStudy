import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int t = 0; t < n; t++){
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			stA.nextToken();
			stB.nextToken();

			int[] A = new int[5];
			int[] B = new int[5];
			char win = 'D';

			while(stA.hasMoreTokens()){
				int num = Integer.parseInt(stA.nextToken());
				A[num]++;
			}

			while(stB.hasMoreTokens()){
				int num = Integer.parseInt(stB.nextToken());
				B[num]++;
			}

			for(int i = 4; i > 0; i--){
				if(A[i] > B[i]){
					win = 'A';
					break;
				} else if(A[i] < B[i]){
					win = 'B';
					break;
				}
			}

			System.out.println(win);
		}
	}
}
