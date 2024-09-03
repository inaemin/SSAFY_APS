package SWEA_2383_점심식사시간;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//solution
class haley
{
    //main
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        //test case
        for(int test_case = 1; test_case <= T; test_case++)
        {
            //지도 크기 입력 및 초기화
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            //사람 위치 저장 배열
            List<int[]> people = new ArrayList<>();
            //계단 위치
            int[][] stair = new int[2][2];
            int stairNum = 0;
            
            //input
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();//map 정보 입력
                    
                    if(map[i][j] == 1) {//사람 있으면
                        people.add(new int[]{i, j});//위치 저장
                    } else if(map[i][j] >= 2) {//계단 있으면 위치 저장
                        stair[stairNum][0] = i;
                        stair[stairNum][1] = j;
                        stairNum++;
                    }
                }
            }
            //사람 수 구하기 & 정답 초기화
            int peopleNum = people.size();
            int answer = Integer.MAX_VALUE;
            //부분집합 생성
            //계단이 2개니 계단 A로 가는 집단과 B로 가는 집단으로 나누어 구함
            for(int i = 0; i <= ((int)Math.pow(2, peopleNum) - 1); i++) {
                //계단 도착시간 구하기
                List<Integer> stairA = new ArrayList<>();
                List<Integer> stairB = new ArrayList<>();

                //계단에 도착하는 시간 저장
                for(int j = 0; j < peopleNum; j++) {
                    if((i & (1<<j)) == 0) {//stairA로 내려가야 함.
                        int time = Math.abs(people.get(j)[0]-stair[0][0]) + Math.abs(people.get(j)[1]-stair[0][1]);
                        stairA.add(time);
                    } else {//stairB로 내려가야 함.
                        int time = Math.abs(people.get(j)[0]-stair[1][0]) + Math.abs(people.get(j)[1]-stair[1][1]);
                        stairB.add(time);
                    }
                }
                
                //정렬
                Collections.sort(stairA);
                Collections.sort(stairB);

                //이동 시작 시간 구하기
                //처음 3개는 도착 후 1초후
                //그 뒤는 3차례 앞의 사람이 계단 다 내려오는 시간 vs 도착 후 1초 지난 시간 비교해 더 큰 쪽을 선택
                //도착 후 1초가 더 크다 -> 앞 사람과 무관, 그냥 1초 후 내려가면 됨. 앞의 사람 계단 내려가고 있다? -> 도착 시간과 무관하게 앞의 사람 내려가면 내려감.
                //계단 A, B에 대해 각각 구함
                for(int k = 0; k < stairA.size(); k++) {
                    if(k < 3) {
                    	stairA.set(k, stairA.get(k) + 1 + map[stair[0][0]][stair[0][1]]); // 수정
                    } else {
                        stairA.set(k, Math.max(stairA.get(k) + 1, stairA.get(k-3)) + map[stair[0][0]][stair[0][1]]); // 수정
                    }
                }
                
                for(int k = 0; k < stairB.size(); k++) {
                    if(k < 3) {
                        stairB.set(k, stairB.get(k) + 1 + map[stair[1][0]][stair[1][1]]);
                    } else {
                        stairB.set(k, Math.max(stairB.get(k) + 1, stairB.get(k-3)) + map[stair[1][0]][stair[1][1]]);
                    }
                }
                
                //종료 시간 구하기
                //계단 A, B의 마지막 사람이 계단을 다 내려간 시점을 비교
                //특정 계단으로만 내려가는 경우도 고려해 else if 처리
                int endtime;
                if(stairA.size() != 0 && stairB.size() != 0) {
                    endtime = Math.max(stairA.get(stairA.size()-1), stairB.get(stairB.size()-1)); // 수정                   
                } else if(stairA.size() == 0) {
                    endtime = stairB.get(stairB.size()-1); // 수정
                } else {
                    endtime = stairA.get(stairA.size()-1); // 수정
                }
                //최소 시간 갱신
                answer = Math.min(answer,endtime);
            }
            
            //결과 출력
            System.out.println("#" + test_case + " " + answer);
        }//end of test case
    }//end of main method
}//end of class
