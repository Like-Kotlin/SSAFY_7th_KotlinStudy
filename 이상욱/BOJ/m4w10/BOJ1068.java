package m4w10;

import java.io.*;
import java.util.*;

public class BOJ1068 {
	static boolean[] visit;
    static ArrayList<ArrayList<Integer>> tree;
    static int root = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        
        tree = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < N; i++){
            tree.add(new ArrayList<Integer>());
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            int p = Integer.parseInt(st.nextToken());
            if(p == -1){
                root = i;
            }else{
                tree.get(p).add(i);
            }
        }
        int removeNode = Integer.parseInt(br.readLine());
        
        remove(removeNode);
        
        for(int i = 0; i < tree.size(); i++){
            if(tree.get(i).contains(removeNode)){
                tree.get(i).remove((Integer) removeNode);
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < tree.size(); i++){
            if(!visit[i] && tree.get(i).isEmpty()){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static void remove(int removeNode){
        for(int i = 0; i < tree.get(removeNode).size(); i++){
            remove(tree.get(removeNode).get(i));
        }
        
        visit[removeNode] = true;
        tree.get(removeNode).clear();
    }
}
