package SWEA_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution {
	
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[] scores; // 각 재료의 점수
	static int[] calories; // 각 재료의 칼로리
	static int maxScore; // 최대 점수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			calories = new int[N];
			maxScore = 0;
			
			for (int i=0; i<N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}

			dfs(0, 0, 0);
			
			// 출력
			System.out.println("#"+t+" "+maxScore);
		}
		sc.close();
	}
	
	static void dfs(int index, int totalScore, int totalCalories) {
		if (index == N || totalCalories > L) {
			if (totalCalories <= L) {
				maxScore = Math.max(maxScore, totalCalories);
			}
			return;
		}
		
		// 현재 재료를 선택하는 경우
		dfs(index + 1, totalScore + scores[index], totalCalories + calories[index]);
		// 현재 재료를 선택하지 않는 경우
		dfs(index + 1, totalScore, totalCalories);
	}	
}
