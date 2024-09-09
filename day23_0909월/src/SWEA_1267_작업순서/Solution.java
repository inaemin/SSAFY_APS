package SWEA_1267_작업순서;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int V, E;  // V: 정점의 개수, E: 간선의 개수
	static int[][] adjArr; // 인접행렬
	static int[] degree; // 진입차수
	static boolean[] visited; // 방문여부
	static Stack<Integer> ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			adjArr = new int[V+1][V+1];
			degree = new int[V+1];
			visited = new boolean[V+1];
			
			for (int i=1; i<=E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adjArr[A][B] = 1;
				degree[B]++;
			} // 입력
			
			ans = new Stack<>();
			for (int i=1; i<=V; i++) {
				if (degree[i] == 0) {
					dfs(i);
				}
			}
			
			// 출력
			System.out.print("#"+t);
			while (!ans.isEmpty()) {
				System.out.print(" " + ans.pop());
			}
			System.out.println();
		}
		sc.close();
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		for (int i=1; i<=V; i++) {
			if (adjArr[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
		ans.push(idx); // 맨 나중에 방문하는거부터 stack에 추가
	}
}
