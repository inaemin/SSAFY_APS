package SWEA_1949_등산로조성;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 개수
	static int N, K; // 지도 한변의 길이, 최대 공사 가능 깊이
	static int[][] MT; // 지도 이차원 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			MT = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					MT[i][j] = sc.nextInt();
				}
			}
			
			// 최대한 긴 등산로
			
			
			// 출력
			System.out.println("#"+t+" ");
		}
		sc.close();
	}
}
