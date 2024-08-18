package SWEA_5215_햄버거다이어트;

import java.util.Scanner;

// 1차원 dp로 풀기
public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] scores = new int[N];
			int[] calories = new int[N];
			
			for (int i=0; i<N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			int[] dp = new int[L+1];
			
			for (int i=0; i<N; i++) {
				for (int j=L; j>=calories[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j-calories[i]] + scores[i]);
				}
			}
			
			System.out.println("#"+t+" "+dp[L]);
		}
		sc.close();
	}
}
