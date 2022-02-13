import java.util.*;
import java.io.*;

public class Main{
    static int row, col;
    static int dongjunPositionX, dongjunPositionY;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //보드 길이
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        //상점 개수
        int storeCnt = Integer.parseInt(br.readLine());

        //방위 및 거리 배열
        int[] cardinal = new int[storeCnt];
        int[] distance = new int[storeCnt];
        for(int i = 0; i<storeCnt; i++){
            st = new StringTokenizer(br.readLine()," ");
            cardinal[i] = Integer.parseInt(st.nextToken());
            distance[i] = Integer.parseInt(st.nextToken());
        }
        //동준 포지션
        st = new StringTokenizer(br.readLine(), " ");
        dongjunPositionX = Integer.parseInt(st.nextToken());
        dongjunPositionY = Integer.parseInt(st.nextToken());

        int total = 0;
        for(int i = 0; i<storeCnt; i++){
            int tmp = findStore(cardinal[i],distance[i]);
            // System.out.println("tmp :" + tmp);
            total += tmp;
        }

        System.out.println(total);
    }

    public static int findStore(int storeX, int storeY){
        if(storeX==dongjunPositionX){
            return Math.abs(storeY-dongjunPositionY);
        }
        else if(Math.abs(storeX-dongjunPositionX) == 1 && 
            !(storeX == 3 && dongjunPositionX == 2) &&
            !(storeX == 2 && dongjunPositionX ==3) ){
            int left, right;
            //북.남 경우
            if(storeX==1 || storeX == 2){
                left = storeY + col + dongjunPositionY;   
                right = Math.abs(storeY-row) + col + Math.abs(dongjunPositionY-row);
                return Math.min(left, right);
            }
            //동,서 경우
            else{
                left = storeY + row + dongjunPositionY;   
                right = Math.abs(storeY-col) + row + Math.abs(dongjunPositionY-col);
                return Math.min(left, right);
            }
        }
        //만약 남 -> 동,서에 상점위치한경우
        else{
            //북
            if(dongjunPositionX == 1){
                if(storeX == 3) return dongjunPositionY + storeY;
                else return Math.abs(row-dongjunPositionY) + storeY;
            }
            //남
            else if(dongjunPositionX == 2){
                if(storeX == 3) return dongjunPositionY + Math.abs(col-storeY);
                else return Math.abs(row-dongjunPositionY) + Math.abs(col-storeY);
            }
            //서
            else if(dongjunPositionX == 3){
                if(storeX == 1) return storeY + dongjunPositionY;
                else return Math.abs(col-dongjunPositionY) + storeY;
            }
            //동
            else{
                if(storeX == 1) return Math.abs(row-storeY) + dongjunPositionY;
                else return Math.abs(storeY-row) + Math.abs(col-dongjunPositionY);
            }
        }
    }
}