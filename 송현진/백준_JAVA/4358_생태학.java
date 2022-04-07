import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        while (true) {
            String st = br.readLine();
            //eof처리 
            if (st == null || st.length() == 0) {
                break;
            }

            totalCnt++;
            //값없을 시 0으로 디폴트 처리 
            hm.put(st, hm.getOrDefault(st, 0) + 1);
        }

        //priorityQueue 사용해도 될것 같은데 이게 간단해서 사용
        Object[] keys = hm.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();

        for (Object key : keys) {
            int val = hm.get(key);
            float f = (float) ((val * 100.0) / totalCnt);
            //소수점 4자리수로 끊기 
            sb.append(key + " " + String.format("%.4f", f) + "\n");
        }
        
        System.out.println(sb);
    }
}