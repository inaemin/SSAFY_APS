package SWEA_7465_창용마을무리의개수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_인접리스트 {
	static int T; // 테스트 케이스 개수
	static int N, M; // N: 사람의 수, M: 서로를 알고 있는 사람의 관계 수
	static List<Integer>[] adjList; // 인접리스트
	static int COUNT; // 무리의 수
	static boolean[] VISITED; // 방문여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			adjList = new ArrayList[N+1];
			for (int i=1; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for (int i=0; i<M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adjList[A].add(B);
				adjList[B].add(A);
			}
			
			COUNT = 0; // 무리의 수 초기화
			VISITED = new boolean[N+1];
			for (int i=1; i<=N; i++) {
				if (!VISITED[i]) {
					dfs(i);
					COUNT++;
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+COUNT);
		}
		sc.close();
		
	}
	
	static void dfs(int idx) {
		VISITED[idx] = true;
		for (int ele : adjList[idx]) {
			if (!VISITED[ele])
				dfs(ele);
		}
	}
}
