import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //중복제거 후 시작
        HashSet<String> removeDupl = new HashSet<>();
        for (String rep : report) {
            removeDupl.add(rep);
        }

        // report에서 각 사람이 신고당한 횟수 countHash으로 정의
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String rep : removeDupl) {
            String[] s = rep.split(" ");
            String reporter = s[0];
            String reportee = s[1];

            ArrayList<String> repList = hm.getOrDefault(reportee, null);
            if (repList == null) {
                repList = new ArrayList<>();
            }

            repList.add(reporter);
            hm.put(reportee, repList);//신고당한사람 , 신고자 리스트 
        }

        // hm기반으로 신고해시 생성 
        HashMap<String, Integer> repHash = new HashMap<>();
        for (ArrayList<String> repList : hm.values()) {
            System.out.println(repList);

            if (repList.size() >= k) {
                for (String reporter : repList) {
                    repHash.put(reporter, repHash.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        // 정답배열에 옮기기 
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = repHash.getOrDefault(id_list[i], 0);
        }

        return answer;
    } 
}