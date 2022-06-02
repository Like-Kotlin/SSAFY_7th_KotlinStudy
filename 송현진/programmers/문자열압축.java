class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        if(s.length() == 1){
            return 1;
        }
        
        // 전체 길이가 / 2 만큼만 같은지 비교 가능 
        for(int i = 1; i<s.length() / 2 + 1; i++){
            String tmpAnswer = "";
            
            String cur = s.substring(0,i);//현재 잘린 글자
            String sub_s = s.substring(i,s.length());//남은 글자
            int cnt = 1;//몆번 똑같은 글자 나오는 지 
            
            //자를 글자 더 없을때 끝남
            while(true){
                //자를 글자가 없다면 기존거 그냥 추가
                if(sub_s.length()<i){
                    tmpAnswer += (cnt == 1) ? cur + sub_s : String.valueOf(cnt) + cur + sub_s;    
                    break;
                }
                
                //다음 글자가 cur과 같다면 압축
                if(sub_s.substring(0,i).equals(cur)){
                    cnt++;
                }
                //다음 글자가 cur과 다르다면
                else{
                    //cur 바꾸고 이전까지의 압축 수와 글자를 정답에 넣기 
                    tmpAnswer += (cnt == 1) ? cur : String.valueOf(cnt) + cur;
                    
                    cur = sub_s.substring(0,i);
                    cnt = 1;
                }
                sub_s = sub_s.substring(i,sub_s.length());
            }
            
            //압축된 글자 길이가 기존 길이보다 짧다면 answer에 넣기 
            answer = Math.min(tmpAnswer.length(), answer);
        }
        
        return answer;
    }
}