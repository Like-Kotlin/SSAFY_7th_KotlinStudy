import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int[] dayArr;
    static int interval;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int dayCnt = Integer.parseInt(st.nextToken());
        interval = Integer.parseInt(st.nextToken());

        dayArr = new int[dayCnt];
        
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<dayCnt; i++){
            dayArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = findLargestTemperature();
        System.out.println(result);
    }

    public static int findLargestTemperature(){
        int maxTemp = -100000001;
        
        for(int i = 0; i<dayArr.length-interval+1; i++){
            int curTempSum = 0;
            for(int j = i; j<i+interval; j++){
                curTempSum += dayArr[j];
            }
            if(maxTemp <= curTempSum){
                maxTemp = curTempSum;
            }
        }
        return maxTemp;
    }
}