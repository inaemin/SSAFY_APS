package SWEA_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 농장의 크기
			int n = sc.nextInt();
			// 농장 2차원배열 초기화
			int[][] farm = new int[n][n];
			// 농장 입력
			for (int i=0; i<n; i++) {
				String line = sc.next();
				for (int j=0; j<line.length(); j++) {
					farm[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
			// 마름모를 읽으면서 수익 계산
			int profit = 0;
			for (int i=0; i<=n/2; i++) {
				for (int j=0; j<n; j++) {
					if (j >= n/2-i && j <= n/2+i) {
						profit += farm[i][j];
					}
				}
			}
			for (int i=n/2+1; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (j > n/2-(n-i) && j < n/2+(n-i)) {
						profit += farm[i][j];
					}
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+profit);
		}
		sc.close();
	}
}