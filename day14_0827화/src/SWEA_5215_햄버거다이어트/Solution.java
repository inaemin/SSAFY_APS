package SWEA_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 개수
	static int N, L; // 재료의 수, 제한 칼로리
	static int[][] ingredients; // 재료의 정보
	static int max_score; // 최대 점수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); // 테스트 케이스 수 입력
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 재료의 수 입력
			L = sc.nextInt(); // 제한 칼로리 입력
			ingredients = new int[N][2]; // 재료 배열 초기화
			for (int i=0; i<N; i++) {
				ingredients[i][0] = sc.nextInt(); // 재료의 점수 입력
				ingredients[i][1] = sc.nextInt(); // 재료의 칼로리 입력
			}
			
			max_score = 0; // 최댓값 초기화
			dfs(0, 0, 0);
			
			// 출력
			System.out.println("#"+t+" "+max_score);
			
		}
		sc.close();
	}
	
	static void dfs(int idx, int sum_score, int sum_calories) {
		if (idx >= N && sum_calories <= L) {
			// 최댓값 업데이트
			max_score = Math.max(max_score, sum_score);
			return;
		}
		if (idx >= N || sum_calories > L) {
			return;
		}
		
		// 선택하지 않은 경우
		dfs(idx+1, sum_score, sum_calories);
		// 선택한 경우
		sum_score += ingredients[idx][0];
		sum_calories += ingredients[idx][1];
		dfs(idx+1, sum_score, sum_calories);
		
	}
}