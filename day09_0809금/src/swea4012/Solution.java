package swea4012;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 식재료의 개수
			int n = sc.nextInt();
			// 시너지의 정보
			int[][] S = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			// 2개의 집합으로 나누기
			
			// 맛은 재료들로 만들 수 있는 시너지의 합.
			// 두 음식의 맛의 차이가 최소가 되는 경우를 찾고,
			// 그 최소값을 출력
			
			
			// 출력
			System.out.println("#"+t+" ");
		}
		sc.close();
	}
}