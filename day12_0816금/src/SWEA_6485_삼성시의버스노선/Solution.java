package SWEA_6485_삼성시의버스노선;

import java.util.Scanner;

// 게리멘더링
// 미세먼지 안녕! 풀어보기

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 버스노선 개수
			int n = sc.nextInt();
			int[][] routes = new int[n][2];
			for (int r=0; r<n; r++) {
				// Ai, Bi 시작-끝 정류장
				routes[r][0] = sc.nextInt() - 1;
				routes[r][1] = sc.nextInt() - 1;
			}
			// p개의 버스 정류장에 대해 각 정류장에 몇 개의 버스노선이 다니는지
			// 구하는 프로그램
			// C1 -> 3 -> 3번 정류장을 지나는 노선 수
			// C2 -> 2 -> 2번 정류장을 지나는 노선 수
			// C3 -> 1 -> 1번 정류장을 지나는 노선 수
			int p = sc.nextInt();
			int[] stops = new int[p];
			for (int j=0; j<p; j++) {
				stops[j] = sc.nextInt() - 1;
			}
			
			int[] routes_cnt = new int[5000];
			for (int i=0; i<n; i++) {
				int start = routes[i][0];
				int end = routes[i][1];
				for (int r=start; r<=end; r++) {
					routes_cnt[r]++;
				}
			}
			
			// 출력
			System.out.print("#"+t);
			for (int i=0; i<p; i++) {
				System.out.print(" "+routes_cnt[stops[i]]);
			}
			System.out.println();
		}
		sc.close();
	}
}
