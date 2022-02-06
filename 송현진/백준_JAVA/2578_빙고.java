import java.util.*;
import java.io.*;

public class Solution{
    static int num = 5;
    static int[][] arr;
    static int[][] checkArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[num][num];
        checkArr = new int[num][num];

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<num; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
  
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<num; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        int index = 0;
        while(true){

            for(int i = 0; i<num; i++){
                for(int j = 0; j<num; j++){

                    if(arr[i][j] == list.get(index)){
                        checkArr[i][j] = 1;
                        index++;
                    }
                    if(index >= 10){
                        int result = findBingo(checkArr);
                        if(result >= 3){
                            System.out.println(index);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int findBingo(int[][] arr){
        int cnt = 0;

        cnt += checkRow();
        cnt += checkCol();
        cnt += checkDownSide();
        cnt += checkUpSide();
        return cnt;
    }

    public static int checkRow(){
        int result = 0;

        for(int i = 0; i<num; i++){
            boolean isItBingo = true;
            for(int j = 0; j<num; j++){
                if(checkArr[i][j] == 0){
                    isItBingo = false;
                }
            }
            if(isItBingo == true){
                result++;
            }
        }

        return result;
    }

    public static int checkCol(){
        int result = 0;

        for(int j = 0; j<num; j++){
            boolean isItBingo = true;
            for(int i = 0; i<num; i++){
                if(checkArr[i][j] == 0){
                    isItBingo = false;
                }
            }
            if(isItBingo == true){
                result++;
            }
        }
        return result;
    }

    public static int checkDownSide(){
        int result = 0;
        int cnt = 0;
        for(int i = 0; i<num; i++){
            if(checkArr[i][i] == 1){
                cnt++;
            }
        }
        if(cnt == 5){
            result = 1;
        }
        return result;
    }

    public static int checkUpSide(){
        int result = 0;
        int cnt = 0;
        for(int i = 0; i<num; i++){
            if(checkArr[i][4-i] == 1){
                cnt++;
            }
        }
        if(cnt == 5){
            result = 1;
        }
        return result;
    }
}
