package 위상정렬;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution_Stack_인접리스트 {
	static int T; // 테스트 케이스 수
	static int N; // 과목의 수
	static List<Integer>[] adjList; // 인접리스트
	static int[] degree; // 진입차수
	static boolean[] visited; // 방문여부
	static int max; // 최소 이수 학기 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			adjList = new ArrayList[N+1];
			degree = new int[N+1];
			visited = new boolean[N+1];
			for (int i=0; i<N+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for (int i=1; i<=N; i++) {
				int k = sc.nextInt();
				degree[i] = k;
				for (int j=0; j<k; j++) {
					adjList[sc.nextInt()].add(i);
				}
			} // 입력
			
			max = 0;
			for (int i=1; i<=N; i++) {
				if (degree[i] == 0)
					dfs(i, 1);
			}
			
			System.out.println("#"+t+" "+(max == 0 ? -1 : max));
			
		}
		sc.close();
	}
	
	static void dfs(int idx, int depth) {
		visited[idx] = true;
		max = Math.max(max, depth);
		
		for (int next : adjList[idx]) {
			degree[next]--;
			if (degree[next] == 0)
				dfs(next, depth+1); // 다음 과목을 탐색하고 학기 수 증가
		}
	}
	
	static String input = "3\r\n"
			+ "4\r\n"
			+ "0\r\n"
			+ "1 1\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2\r\n"
			+ "1 2\r\n"
			+ "1 1\r\n"
			+ "4\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "0 0\r\n"
			+ "0 0\r\n";
}
