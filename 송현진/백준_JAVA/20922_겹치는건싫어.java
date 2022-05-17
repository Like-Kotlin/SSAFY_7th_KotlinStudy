import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int start = 0;
        int end = 0;
        // 100000이하의 정수로 이루어진 ㅇㅇ
        int[] cnt = new int[1000001];

        while (end < arr.length) {
            while (end < arr.length && cnt[arr[end]] + 1 <= M) {
                cnt[arr[end]]++;
                end++;
            }
            int len = end - start;
            ans = Math.max(len, ans);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}
