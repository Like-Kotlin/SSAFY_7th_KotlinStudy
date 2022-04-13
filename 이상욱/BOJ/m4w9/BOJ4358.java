package m4w9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ4358 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int tot = 0;
		
		while(true) {
			
			String tree = br.readLine();
			if(tree == null) {
				break;
			}
			
			tot++;
			
			map.put(tree, map.getOrDefault(tree, 0) + 1);
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String key : map.keySet()) {
			list.add(key);
		}
		
		Collections.sort(list);
		
		for(String key : list) {
			String tName = key;
			int cnt = map.get(key);
			double p = cnt * 100.0 / tot;
			
			sb.append(tName+" "+String.format("%.4f", p)+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
		
	}
}
