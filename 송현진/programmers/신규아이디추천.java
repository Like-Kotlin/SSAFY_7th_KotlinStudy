import java.util.*;

class Solution {
    public String solution(String new_id) {

        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = first(new_id);
        System.out.println("1 : "+new_id);
        
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = second(new_id);
        System.out.println("2 : "+new_id);
        
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = third(new_id);
        System.out.println("3 : "+new_id);
        
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = fourth(new_id);
        System.out.println("4 : "+new_id);
        
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        new_id = fifth(new_id);
        System.out.println("5 : "+new_id);
        
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        new_id = sixth(new_id);
        System.out.println("6 : "+new_id);
        
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        new_id = seventh(new_id);
        System.out.println("7 : "+new_id);
        
        return new_id;
    }
    public static String first(String id){
        return id.toLowerCase();        
    }
    
    public static String second(String id){
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String ans = "";
        
        for(int i = 0; i<id.length(); i++){
            if('a'<= id.charAt(i) && id.charAt(i)<='z'){
                //String.valueOf(cr); 이 방법도 있다.
                ans += Character.toString(id.charAt(i));
            }
            else if('0' <= id.charAt(i) && id.charAt(i)<='9'){
                ans += Character.toString(id.charAt(i));
            }
            else if(id.charAt(i) == '-'){
                ans += Character.toString(id.charAt(i));
            }
            else if(id.charAt(i) == '_'){
                 ans += Character.toString(id.charAt(i));
            }
            else if(id.charAt(i) == '.'){
                 ans += Character.toString(id.charAt(i));
            }
        }
        
        return ans;
    }
    
    public static String third(String id){
        String ans = "";
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        
        int cnt = 0;
        for(int i = 0; i<id.length(); i++){
            if(id.charAt(i) == '.'){
                cnt++; 
                //마지막 자리일 경우 체크 
                if(i+1 == id.length()){
                    ans += Character.toString('.');
                }
                continue;
            }
            else if(cnt >= 2 && id.charAt(i) != '.'){
                ans += Character.toString('.');
                cnt= 0;
            }
            else if(cnt == 1 && id.charAt(i) != '.'){
                ans += Character.toString('.');
                cnt= 0;
            }
            
            ans += Character.toString(id.charAt(i));
        }
        return ans;
    }
    
    public static String fourth(String id){
        //비었으면 그냥 리턴 
        if(id.length() == 1){
            System.out.println("?????");
            if(id.equals(".")){
                return "";
            }
            return id;
        }
        
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        
        //처음일 경우
        if(id.charAt(0) == '.'){
            id = id.substring(1, id.length());
        }
        if(id.equals(".")){
            return "";
        }
        
        if(id.charAt(id.length()-1) == '.'){
            id = id.substring(0, id.length()-1);
        }
        return id;        
    }
    
    public static String fifth(String id){
        String ans = "";
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(id.length() == 0 ){
            return "a";
        }
        return id;        
    }
    
    public static String sixth(String id){
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(id.length() >= 16){
            id = id.substring(0,15);
            id = fourth(id);
        }
        return id;
    }
    
    public static String seventh(String id){
        String lastLetter = Character.toString(id.charAt(id.length()-1));
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(id.length() <= 2){
            while(id.length() != 3){
                id += lastLetter;
            }   
        }
        return id;        
    }
}