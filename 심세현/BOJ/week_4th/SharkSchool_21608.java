package beckjoon.embody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SharkSchool_21608 {

    // emptyList 에 넣을 좌석 정보
    static class Seat {
        int x; // 행
        int y; // 열

        public Seat(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, TOTAL;
    private static int[][] CLASS; // 교실배열
    private static int[][] STUDENT; // 학생 배열 [순서][0] 본인, [순서][1]~[순서][4] 좋아하는 학생
    private static ArrayList<Seat> possibleList; // 유력한 자리 목록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        CLASS = new int[N][N];
        STUDENT = new int[N*N][5];
        // 학생 배열 채우기
        StringTokenizer st;
        for(int i=0; i<N*N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                STUDENT[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        // 자리 배정하기
        makeSeat();
        // 만족도 구하기
        TOTAL = 0;
        getTotal();
        System.out.print(TOTAL);
    }

    // 상,하,좌,우 4방 탐색
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    // 자리 배정하기
    private static void makeSeat() {
        for(int i=0; i<N*N; i++){ // 첫번째 학생부터 앉기
            int maxCnt = 0;
            int maxEmpty = 0;
            boolean cntFlag = false;
            possibleList = new ArrayList<>();

            int favoriteX = 0;
            int favoriteY = 0;
            // 1.인접자리 좋아하는 학생 수 구하기 + 2.인접자리가 가장 많이 비어있는 칸 찾기 (교실 다 돌기)
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if(CLASS[x][y] == 0){ // 빈자리가 아닌 경우에만
                        int cnt = 0; // 인접자리 좋아하는 학생 수 체크
                        int empty = 0; // 인접자리 빈자리 체크

                        for(int d=0; d<4; d++){ // x,y 위치에서 인접자리 확인(4방 탐색)
                            int newX = x + dx[d];
                            int newY = y + dy[d];
                            // 인접자리가 벽이 아닌 경우
                            if(checkWall(newX, newY))
                            {
                                // 인접자리가 빈자리인 경우
                                if(CLASS[newX][newY] == 0){
                                    empty++; continue;
                                }
                                for(int n=1; n<5; n++){ // 인접자리 좋아하는 학생 체크
                                    if(CLASS[newX][newY] == STUDENT[i][n]) cnt++;
                                }
                            }
                        }
                        // 인접자리 좋아하는 학생이 가장 많은 x,y 체크
                        if(cnt > maxCnt){
                            maxCnt = cnt;
                            maxEmpty = empty;
                            favoriteX = x;
                            favoriteY = y;
                            cntFlag = false;
                            possibleList.clear();
                            possibleList.add(new Seat(x,y));
                        }
                        else if(cnt == maxCnt){ cntFlag = true; }
                        else if(cnt < maxCnt) continue;
                        // 1번조건이 충족된 경우 빈자리가 가장 많은 x,y 체크
                        if(maxCnt > 0){ // 1번 조건이 충족된 경우
                            if(cntFlag){ // 1번 조건이 여러개 일 때,
                                if(empty > maxEmpty){ // 1번조건을 충족하고 인접자리에 빈자리가 가장 많은 자리 체크
                                    maxEmpty = empty;
                                    possibleList.clear();
                                    possibleList.add(new Seat(x,y));
                                }
                                else if(empty == maxEmpty){ // 1번조건을 충족하고 2번 조건이 여러개인 경우
                                    possibleList.add(new Seat(x,y));
                                }
                            }
                        }
                        else { // 1번 조건이 충족되지 않은 경우 or 첫번째 일때
                            if(empty > maxEmpty){ // 인접자리에 빈자리가 가장 많은 자리 체크
                                maxEmpty = empty;
                                possibleList.clear();
                                possibleList.add(new Seat(x,y));
                            }
                            else if(empty == maxEmpty){ // 1번조건을 충족하고 2번 조건이 여러개인 경우
                                possibleList.add(new Seat(x,y));
                            }
                        }
                    }
                }
            }
            // 후보목록 오름차순 정렬
            Collections.sort(possibleList, new Comparator<Seat>() {
                @Override
                public int compare(Seat o1, Seat o2) { // 행 오름차순, 이후 열 오름차순
                    if(o1.y != o2.y){
                        return o1.y - o2.y;
                    }
                    else { return o1.x - o2.x; }
                }
            });
            // 1번 조건이 다수인 경우 체크
            if(cntFlag){
                Seat seat = possibleList.get(0);
                CLASS[seat.x][seat.y] = STUDENT[i][0];
            }
            else{ // 1번 조건이 하나인 경우 착석
                CLASS[favoriteX][favoriteY] = STUDENT[i][0];
            }
        }
    }

    // 교실 인접자리 벽체크
    private static boolean checkWall(int newX, int newY) {
        if(newX < 0 || newX >= N || newY < 0 || newY >= N){
            return false;
        }
        return true;
    }

    // 자리 배정이 끝난 후 만족도 구하기
    private static void getTotal() {
        // 첫번째 칸 부터 인접자리 좋아하는 학생 수 구하기
        for(int x=0; x<N; x++) {
            for (int y=0; y<N; y++) {
                int cnt = 0;
                // x,y 위치에서 인접자리 확인(4방 탐색)
                for(int i=0; i<N*N; i++){
                    if(CLASS[x][y] == STUDENT[i][0]){
                        for(int d=0; d<4; d++){
                            int newX = x + dx[d];
                            int newY = y + dy[d];
                            // 인접자리가 벽이 아닌 경우
                            if(checkWall(newX, newY)) {
                                for(int n=1; n<5; n++){ // 인접자리 좋아하는 학생 체크
                                    if(CLASS[newX][newY] == STUDENT[i][n]){
                                        cnt++;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                if(cnt == 1){ TOTAL++; }
                else if(cnt == 2){ TOTAL += 10; }
                else if(cnt == 3){ TOTAL += 100; }
                else if(cnt == 4){ TOTAL += 1000; }
            }
        }
    }

}
