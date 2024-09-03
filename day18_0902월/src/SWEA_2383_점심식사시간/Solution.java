package SWEA_2383_점심식사시간;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스의 개수
	static int N; // 방의 한변의 길이
	static int[][] STAIR; //계단 [row, col, 길이] 이차원 배열
	static int PERSON; // 사람 수
	static List<int[]> PERSONS; // 사람들의 [row, col] 이차원 배열
	static int[] SEL; // 사람들의 계단 선택 배열
	static int TIME; // 계단을 내려가 이동이 완료되는 시간
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); // 테스트 케이스 입력
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 지도의 한 변 입력
			STAIR = new int[2][]; // 계단 row, col, 길이 이차원배열
			PERSON = 0; // 사람 수
			PERSONS = new ArrayList<>(); // 사람들의 [row, col] 이차원 배열 초기화
			int s_idx = 0; // 계단 배열 인덱스 초기화
			for (int i=0; i<N*N; i++) {
				// 1은 사람. 2 이상은 계단의 입구를 나타내며 그 값은 계단의 길이를 의미
				int input = sc.nextInt();
				int row = i / N;
				int col = i % N;
				if (input == 1) {
					PERSON++;
					PERSONS.add(new int[] {row, col}); // 사람 row, col
				}
				if (input >= 2) {
					STAIR[s_idx++] = new int[] {row, col, input}; // 계단 row, col, 길이
				}
			}
			// 계단 입구까지 이동시간 + 계단을 내려가는 시간
			// 계단 입구에 도착하면 1분 후 아래칸으로 내려갈 수 있음
			// 계단에는 최대 3명까지만 올라가있을 수 있고, 그 중 한명이 계단을
			// 내려갈때까지 계단 입구에서 대기해야 함 -> 큐
			// 계단은 반드시 두개임. 서로의 위치가 겹치지 않음.
			
			TIME = Integer.MAX_VALUE;
			SEL = new int[PERSON];
			
			subset(0);			
			
			// 출력
			System.out.println("#"+t+" "+TIME);
		}
		sc.close();
	}
	
	// 사람들이 선택한 계단 저장
	static void subset(int idx) {
		if (idx == PERSON) {
			simul();
			return;
		}
		
		// 선택한 경우
		SEL[idx] = 1;
		subset(idx+1);
		// 선택하지 않은 경우
		SEL[idx] = 0;
		subset(idx+1);
	}
	
	// 계단 도착 시간에 따라 오름차순으로 정렬.
	// 각 계단에 대해 시간 계산
	// 두 계단 중 더 오래 걸린 시간이 전체 소요 시간
	// 최소 시간 갱신
	static void simul() {
		PriorityQueue<Integer> minpq0 = new PriorityQueue<>(); 
		PriorityQueue<Integer> minpq1 = new PriorityQueue<>();
		
		// 각 사람의 계단 도착 시간 계산
		for (int i=0; i<PERSON; i++) {
			int arrivalTime = Math.abs(PERSONS.get(i)[0] - STAIR[SEL[i]][0]) + Math.abs(PERSONS.get(i)[1] - STAIR[SEL[i]][1]);
			if (SEL[i] == 0) {
				minpq0.add(arrivalTime);
			} else {
				minpq1.add(arrivalTime);
			}		
		}
		
		// 각 계단에 대해 시뮬레이션 수행
		int time0 = processStair(minpq0, STAIR[0][2]);
		int time1 = processStair(minpq1, STAIR[1][2]);
		
		// 두 계단 중 더 오래 걸린 시간이 전체 소요시간
		int totalTime = Math.max(time0, time1);
		
		// 최소 시간 갱신
		TIME = Math.min(TIME,  totalTime);
	}
	
	// 각 계단에서 사람들이 다 내려갈 때까지의 시간 계산
	// arrivalQueue, onStair, waiting으로 3개의 큐를 만들어서
	// time을 올리면서 큐에서 옮겨준다.
	static int processStair(PriorityQueue<Integer> arrivalQueue, int stairLength) {
		int time = 0;
		Queue<Integer> onStair = new LinkedList<>(); // 계단이 있는 사람들이 내려갈 시간
		Queue<Integer> waiting = new LinkedList<>(); // 계단 앞에서 대기 중인 사람들

		// 
		while (!arrivalQueue.isEmpty() || !onStair.isEmpty() || !waiting.isEmpty()) {
			// 계단이 다 내려간 사람 제거
			// onStair에 사람이 있고, 첫 원소가 time 이하라면 onStair에서 없애준다.
			while (!onStair.isEmpty() && onStair.peek() <= time) {
				onStair.poll();
			}
			
			// 대기 중인 사람을 계단에 올림
			// waiting에 사람이 있고, onStair에 사람이 3명 미만이라면 onStair에 추가하고
			// waiting에서 없애준다.
			while (!waiting.isEmpty() && onStair.size() < 3) {
				onStair.offer(time + stairLength);
				waiting.poll();
			}
			
			// 새로운 사람이 계단 입구에 도착
			// arrivalQueue에 사람이 있고, 첫 원소가 time 이하라면 계단에 도착했을 것이다.
			// 만약 onStair에 3명 미만이 있다면 바로 onStair에 추가한다. (대기시간 1분 포함)
			// 아니면 waiting에 추가한다.
			while (!arrivalQueue.isEmpty() && arrivalQueue.peek() <= time) {
				if(onStair.size() < 3) {
					onStair.offer(time + stairLength + 1);
				} else {
					waiting.offer(arrivalQueue.peek());
				}
				arrivalQueue.poll();
			}
			
			// 다음 이벤트 시간으로 점프
			// arrivalQueue에 사람이 있고, onStair와 waiting이 비었다면
			// time을 arrivalQueue의 첫번째 원소의 도착시간으로 바꿔준다.
			if (!arrivalQueue.isEmpty() && onStair.isEmpty() && waiting.isEmpty()) {
				time = arrivalQueue.peek();
			// onStair에 사람이 있다면 onStair에 사람이 빠져야 waiting에서 onStair로 들어올 수 있으므로
			// 다음 사람이 내려갈 시간과 다음 사람이 도착할 시간 중 빠른 시간으로 점프
			} else if (!onStair.isEmpty()) {
				time = Math.min(onStair.peek(), arrivalQueue.isEmpty() ? Integer.MAX_VALUE : arrivalQueue.peek());
			// waiting에 사람이 있다면 1만 증가
			} else if (!waiting.isEmpty()) {
				time++;
			// 비었다는 뜻
			} else {
				break;
			}
		}
		return time;
	}
}