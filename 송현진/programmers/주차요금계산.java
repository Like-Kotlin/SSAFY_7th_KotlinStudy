import java.util.*;
class Solution {
    //차량 입출차 시간 누적으로 구하기 
    public static HashMap<String, Integer> hm;
    public static int[] arr;
    public int[] solution(int[] fees, String[] records) {

        //입차 같은 차 두번 가능 so 해시맵 불가능 
        ArrayList<Node> in = new ArrayList<>();
        ArrayList<Node> out = new ArrayList<>();
        
        hm = new HashMap<>();
        
        for(int i = 0; i<records.length; i++){
            String[] input = records[i].split(" ");
            //0 -> 시간, 1 -> 차량번호, 2->내역
            if(input[2].equals("IN")){
                in.add(new Node(input[1],input[0]));
            }else{
                out.add(new Node(input[1],input[0]));
            }
        }
        
        for(int i = 0; i<in.size(); i++){
            boolean isOut = false;
            
            for(int j = 0; j<out.size(); j++){
                //이미 없어진 자리면 패스 
                if(out.get(j).num.equals("-1")){
                    continue;
                }
                   //입차.출차 있으면 
                if(in.get(i).num.equals(out.get(j).num)){
                    //현재 저장 
                    Node cur_in = in.get(i);
                    Node cur_out = out.get(j);
                    
                    calculateTime(cur_in, cur_out);
                    
                    //나갔다면 true로 변경 
                    isOut = true;
                    out.get(j).num = "-1";//차량 번호 바꿔서 접근 불가로 만듦
                    break;
                }
            }
            //나간 적 없으면 
            if(!isOut){
                //22시로 계산 
                Node cur_in = in.get(i);
                Node cur_out = new Node(cur_in.num, "23:59");
                
                calculateTime(cur_in, cur_out);
            }
        }
        
        
        //차량번호 작은 자동차부터 청구할 주차요금을 차례대로 정수배열에 담아서 리턴 
        arr = new int[hm.size()];
        //요금 계산해서 배열에 넣어서 반환
        cal(fees);
        
        return arr;
    }
    
    public static void calculateTime(Node i,Node o){
        String[] in = i.time.split(":");
        String[] out = o.time.split(":");
        
        //전체 주차 시간 구하기 
        int startH = Integer.parseInt(in[0]);
        int startM = Integer.parseInt(in[1]);
        
        int outH = Integer.parseInt(out[0]);
        int outM = Integer.parseInt(out[1]);
        
        //분 계산 
        int total = outM-startM;
        if(total < 0){
            total += 60;
            outH -= 1;
        }
        
        //시 계산 
        int totalH = outH-startH;
        total += totalH * 60;
        
 
        //getOrDefault에 키값 넣어야 함...!
        hm.put(i.num, hm.getOrDefault(i.num,0)+total);
    }
    
    public static void cal(int[] fee){

        ArrayList<Time> tmp = new ArrayList<>();
        
        //해시맵 돌면서 주차 확인 
        for(String s : hm.keySet()){
            int result = fee[1];
            //기본시간에서 뺐는데 +나 0 나오면 무료임 
            if(fee[0] - hm.get(s) >= 0){
                tmp.add(new Time(Integer.parseInt(s),result));  
                continue;
            }

            //시간남으면 
            int remain = hm.get(s) - fee[0];//기본 시간 뺀 나머지 시간

            //ceil올림 
            result += Math.ceil(remain/(double)fee[2]) * fee[3]; 
            tmp.add(new Time(Integer.parseInt(s), result));
        }
        
        int arr_i = 0;
        while(!tmp.isEmpty()){
            int min = 1000000;
            int index = 0;
            for(int i = 0; i<tmp.size(); i++){
         
                if(min > tmp.get(i).num){
                    min = tmp.get(i).num;
                    index = i;
                }
            }
            arr[arr_i] = tmp.get(index).time;
            arr_i++;
            tmp.remove(index);
        }
        
    }
}
class Time{
    int num;
    int time;
        public Time(int num, int time){
        this.num = num;
        this.time = time;
    }
}

class Node{
    String num;
    String time;
    
    public Node(String num, String time){
        this.num = num;
        this.time = time;
    }
}