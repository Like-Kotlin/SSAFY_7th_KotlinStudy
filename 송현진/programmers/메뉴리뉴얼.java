import java.util.*;

class Solution {
    static HashSet<String>[] hs;
    static HashMap<String, Integer> hm = new HashMap<>();
    static int max = 0;
    public String[] solution(String[] orders, int[] course) {
        TreeSet<String> arr = new TreeSet<>();

        //초기화해주기 
        hs = new HashSet[orders.length];
        for(int i = 0; i<hs.length; i++){
            hs[i] = new HashSet<String>();
        }

        int idx = 0;
        //손님들 각자 메뉴 HashSet에 추가
        while(idx < orders.length){
            for(int j = 0; j < orders[idx].length(); j++){

                //해시에 추가  
                hs[idx].add( String.valueOf((char)orders[idx].charAt(j)) );
            }
            idx++;
        }

        //1. 조합 통해 각 orders내부의 course 수대로 조합하고 각 손님들의 set에 들어있는지 확인
        for(int i = 0; i<course.length; i++){
            int courseValue = course[i];

            max = 0;
            hm = new HashMap<>();

            //손님 수만큼 courseValue 수만큼 조합 확인 
            for(int j = 0; j<orders.length; j++){

                String[] tmp = new String[courseValue];//2
                boolean[] visit = new boolean[orders[j].length()];//5

                //정렬하고
                String[] cur_order = orders[j].split("");
                Arrays.sort(cur_order);
                String newInput = String.join("",cur_order);
                cur_order = newInput.split("");

                comb(0,0, courseValue, tmp, visit, cur_order,j);
            }

            //각 courseValue맵마다 최댓값 찾고 해당 값과 같은 String모두 추가 
            for(Map.Entry<String,Integer> map : hm.entrySet()){
                if(map.getValue() == max){
                    arr.add(map.getKey());
                }
                // System.out.println(map.getKey()+" "+map.getValue());
            }   
        }

        String[] answer = new String[arr.size()];
        int i = 0;
        for(String set : arr){
            answer[i++] = set;
        }
        return answer;
    }

    public static void comb(int cur, int s, int N, String[] tmp, boolean[] visit, String[] cur_order,int cur_customer){
        if(cur == N){
            //조합된 배열 넘기기
            checkCustomer(tmp, cur_customer);
            return;
        }

        for(int i = s; i<cur_order.length; i++){
            if(!visit[i]){
                visit[i] = true;
                tmp[cur] = cur_order[i];
                comb(cur+1, i+1, N, tmp, visit, cur_order,cur_customer);
                visit[i] = false;
            }
        }
    }

    public static void checkCustomer(String[] tmp, int cur_customer){

        //2. 손님들의 메뉴 구성에 들어있다면 맵에 횟수 추가
        for(int i = 0; i<hs.length; i++){

            //현재 손님의 메뉴와 찾는 메뉴 겹치면 패스 
            if(i == cur_customer){
                continue;
            }

            //해당 손님의 메뉴만큼 돌면서 다 포함하고 있는지 확인 
            int cnt = 0;
            for(int j = 0; j<tmp.length; j++){

                if(hs[i].contains(tmp[j])){
                    cnt++;
                }
            }

            //모두 포함하고 있으면
            if(cnt == tmp.length){
                //맵에 추가
                String key = String.join("",tmp);
                hm.put(key, hm.getOrDefault(key,0)+1);

                max = Math.max(max, hm.get(key));
            }
        }
    }
}
