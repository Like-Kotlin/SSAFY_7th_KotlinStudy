import java.io.*;
import java.util.*;

class Solution {
    static int N, M, train[][], answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());// 기차
        M = Integer.parseInt(st.nextToken());// 명령

        train = new int[N + 1][21];

        int order, tidx, idx;
        while (M-- != 0) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());

            if (order == 1 || order == 2) {
                tidx = Integer.parseInt(st.nextToken());// i
                idx = Integer.parseInt(st.nextToken()) - 1;// x

                if (order == 1) {
                    train[tidx][idx] = 1;// 승차
                } else {
                    train[tidx][idx] = 0;// 하차
                }
            } else {
                tidx = Integer.parseInt(st.nextToken());

                if (order == 3) {
                    back(tidx);
                } else {
                    front(tidx);
                }
            }
        }

        HashSet<String> hs = new HashSet<>();

        for (int i = 1; i < N + 1; i++) {
            //array.toString을 통해 문자열로 만들어서 저장하기 -> 빠르게 비교가 가능해짐 -> 중복되는건 저장 안됌.
            hs.add(Arrays.toString(train[i]));
        }

        System.out.println(hs.size());
    }

    // 앞으로 보내기
    public static void front(int tidx) {
        for (int i = 0; i < 19; i++) {
            train[tidx][i] = train[tidx][i + 1];
        }
        // 마지막은 항상 없음
        train[tidx][19] = 0;
    }

    // 뒤로 보내기
    public static void back(int tidx) {
        for (int i = 19; i >= 1; i--) {
            train[tidx][i] = train[tidx][i - 1];
        }
        // 처음은 항상 없음
        train[tidx][0] = 0;
    }
}
