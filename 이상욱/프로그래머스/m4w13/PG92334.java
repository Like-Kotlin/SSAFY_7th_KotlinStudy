package m4w13;

import java.util.*;


public class PG92334 {
	
	
}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Arrays.sort(report);
        
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, ArrayList<String>> hm1 = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
        	hm.put(id_list[i], 0);
        	hm1.put(id_list[i], new ArrayList<String>());
        }
        
        
        String preReport = "";
        
        for(int i = 0; i < report.length; i++) {
        	if(preReport.equals(report[i])) {
        		continue;
        	}
        	
        	preReport = report[i];
        	
        	String[] content = report[i].split(" ");
        	
        	String p1 = content[0];
        	String p2 = content[1];
        	
        	hm.put(p2, hm.getOrDefault(p2, 0)+1);
        	
        	ArrayList<String> list = hm1.getOrDefault(p1, new ArrayList<String>());
        	list.add(p2);
        	hm1.put(p1, list);
        	
        }
        
        for(String key : hm.keySet()) {
        	if(hm.get(key) >= k) {
        		for(int i = 0; i < id_list.length; i++) {
        			String p = id_list[i];
        			if(hm1.get(p).contains(key)) {
        				answer[i]++;
        			}
        		}
        	}
        }
        
        
        return answer;
    }
}