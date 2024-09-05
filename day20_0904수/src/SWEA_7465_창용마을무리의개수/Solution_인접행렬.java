package SWEA_7465_창용마을무리의개수;

import java.util.Scanner;

public class Solution_인접행렬 {
	static int T; // 테스트 케이스 개수
	static int N, M; // N: 사람의 수, M: 서로 아는 사람의 관계 수
	static int[][] adjArr; // 인접행렬
	static int ANS; // 무리의 수
	static boolean[] VISITED; // 방문여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 사람의 수
			M = sc.nextInt(); // 서로 아는 사람의 관계 수		
			adjArr = new int[N+1][N+1]; // 초기화
			
			for (int i=0; i<M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adjArr[A][B] = 1;
				adjArr[B][A] = 1;
			} // 입력 끝
			
			ANS = 0;
			VISITED = new boolean[N+1];
			for (int i=1; i<=N; i++) {
				if (!VISITED[i]) {
					dfs(i);
					ANS++;
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+ANS);
		}
		sc.close();
	}
	
	static void dfs(int idx) {
		VISITED[idx] = true;
		for (int i=1; i<=N; i++) {
			if (adjArr[idx][i] == 1 && !VISITED[i]) {
				dfs(i);
			}
		}
	}
}
