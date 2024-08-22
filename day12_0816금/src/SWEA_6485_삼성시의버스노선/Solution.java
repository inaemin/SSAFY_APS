package SWEA_6485_삼성시의버스노선;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			// 버스노선 개수
			int n = sc.nextInt();
			// 전체 5000개 버스정류장
			int[] routes_cnt = new int[5000];
			for (int r=0; r<n; r++) {
				// Ai, Bi 시작-끝 정류장
				int start = sc.nextInt() - 1;
				int end = sc.nextInt() - 1;
				for (int i=start; i<=end; i++) {
					routes_cnt[i]++;
				}
			}
			// p개의 버스 정류장에 대해 각 정류장에 몇 개의 버스노선이 다니는지
			// 구하는 프로그램
			// C1 -> 3 -> 3번 정류장을 지나는 노선 수
			// C2 -> 2 -> 2번 정류장을 지나는 노선 수
			// C3 -> 1 -> 1번 정류장을 지나는 노선 수
			int p = sc.nextInt();
			// 출력
			System.out.print("#"+t);
			for (int j=0; j<p; j++) {
				int stop = sc.nextInt() - 1;
				System.out.print(" "+routes_cnt[stop]);
			}
			System.out.println();
		}
		sc.close();
	}
}
