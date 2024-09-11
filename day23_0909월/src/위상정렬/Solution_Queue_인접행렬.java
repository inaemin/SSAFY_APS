package 위상정렬;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_Queue_인접행렬 {
	static int T; // 테스트 케이스 수
	static int N; // 과목의 수
	static int[][] adjArr; // 인접행렬
	static int[] degree; // 진입차수
	static int min_semester; // 최소 학기 수
	
	/*
	 * 
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			adjArr = new int[N+1][N+1];
			degree = new int[N+1];
			for (int i=1; i<=N; i++) {
				int k = sc.nextInt();
				degree[i] = k;
				for (int j=0; j<k; j++) {
					adjArr[sc.nextInt()][i] = 1;					
				}
			} // 입력
			
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i=1; i<=N; i++) {
				if (degree[i] == 0)
					queue.add(i);
			}
			
			int count = 0;
			int[] semester = new int[N+1]; // 각 과목을 수강하기까지 필요한 최소학기 수
			Arrays.fill(semester, 1);
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				for (int i=1; i<=N; i++) {
					if (adjArr[curr][i] == 1) {
						degree[i]--;
						if (degree[i] == 0) {
							queue.add(i);
							semester[i] = semester[curr] + 1;							
						}
					}
				}
				count++; // 과목 수강완료
			}
			
			min_semester = -1;
			if (count == N) {
				for (int i=1; i<=N; i++) {
					min_semester = Math.max(semester[i], min_semester);
				}
			}
			
			System.out.println("#"+t+" "+min_semester);
			
		}
		sc.close();
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
