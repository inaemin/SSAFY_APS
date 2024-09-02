package SWEA_2383_점심식사시간;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스의 개수
	static int N; // 방의 한변의 길이
	static int[][] MAP; // N*N 크기의 지도
	static int time; // 계단을 내려가 이동이 완료되는 시간
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); // 테스트 케이스 입력
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 지도의 한 변 입력
			int[][] MAP = new int[N][N]; // 지도 초기화
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 1은 사람. 2 이상은 계단의 입구를 나타내며 그 값은 계단의 길이를 의미
					MAP[i][j] = sc.nextInt();
				}
			}
			// 계단 입구까지 이동시간 + 계단을 내려가는 시간
			// 계단 입구에 도착하면 1분 후 아래칸으로 내려갈 수 있음
			// 계단에는 최대 3명까지만 올라가있을 수 있고, 그 중 한명이 계단을
			// 내려갈때까지 계단 입구에서 대기해야 함
			// 큐?
			
			
			
			
			
			// 출력
			System.out.println("#"+t+" ");
		}
		sc.close();
	}
}