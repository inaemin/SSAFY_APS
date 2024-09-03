package SWEA_1952_수영장;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 수
	static int[] price; // 이용권 요금
	static int[] plan; // 12개월 이용계획
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 이용권 요금 입력
			price = new int[4];
			for (int i=0; i<4; i++) {
				price[i] = sc.nextInt();
			}
			// 12개월 이용 계획
			plan = new int[12+1];
			for (int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			}
			// 매월 최솟값을 저장할 dp배열 초기화
			int[] dp = new int[13];
			for (int i=1; i<=12; i++) {
				dp[i] = dp[i-1] + Math.min(price[0] * plan[i], price[1]);
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i-3] + price[2]);
				}
			}
			
			// 1년 이용권과 dp[12]을 비교하여 작은 값이 최소 비용
			int min_expanse = Math.min(price[3], dp[12]);
			
			// 출력
			System.out.println("#"+t+" "+min_expanse);
		}
		sc.close();
	}
}