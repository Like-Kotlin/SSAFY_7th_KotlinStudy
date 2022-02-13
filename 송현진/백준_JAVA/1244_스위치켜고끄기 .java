import java.util.*;
import java.io.*;

public class Solution{
    static int[] switchState;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        switchState = new int[switchCnt+1];
        
        for(int i = 1; i<=switchCnt; i++){
            switchState[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i<studentCnt; i++){
            st = new StringTokenizer(br.readLine()," ");
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            findResult(gender, number);
        }

        for(int i = 1; i<=switchCnt; i++){
            if(i % 20 == 0){
                System.out.print(switchState[i] + "\n");
            }
            else{
                System.out.print(switchState[i]+" ");
            }
        }
        
    }
    public static void findResult(int gender, int number){
        //남자
        if(gender == 1){
            changeSwitchMultiple(number);
        }
        //여자
        else{
            changeSwitchSymmetry(number);
        }
    }

    public static void changeSwitchMultiple(int number){//1
        for(int i = switchState.length-1; i>=1; i--){
            if(i % number == 0){
                changeState(i);
            }
        }
    }

    public static void changeSwitchSymmetry(int number){
        int left = number;
        int right = number;
        if(number == 1 || number == switchState.length-1){
            changeState(number);
            return;
        }
        else{
            changeState(number);
            while(true){
                left = left - 1;
                right = right + 1;
                if(left <= 0 || right >= switchState.length){
                    return;
                }
                if(switchState[left] == switchState[right]){
                    changeState(left);
                    changeState(right);
                }
                else if(switchState[left] != switchState[right]){
                    return;
                }
            }
        }
    }
    
    public static void changeState(int index){
        switchState[index] = switchState[index]==1 ? 0:1;
    }
}
