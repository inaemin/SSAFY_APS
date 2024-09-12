package SWEA_1970_쉬운거스름돈;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 수
	static int N; // 거슬러 주어야 할 금액
	static int[] money = new int[] {10, 50, 100, 500, 1000, 5000, 10000, 50000};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			int[] dp = new int[N+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			
			for (int i=1; i<=N; i++) {
				for (int m : money) {
					if (i >= m && dp[i-m] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[i-m] + 1);
					}
				}
			}
			
			int[] result = new int[money.length];
			for (int i=money.length-1; i>=0; i--) {
				if (N >= money[i]) {
					result[i] = N / money[i];
					N %= money[i];
				}
			}
			
			// 출력
			System.out.println("#"+t);
			for (int i=money.length-1; i>=0; i--) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}