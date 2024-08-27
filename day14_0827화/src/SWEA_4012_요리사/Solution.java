package SWEA_4012_요리사;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 수
	static int N; // 음식의 개수
	static int[][] S; // 음식간의 시너지
	static int min_diff; // 맛 차이의 최소
	static int[] comb; // 조합을 기록하는 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); // 테스트 케이스 수 입력
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 음식 개수 입력
			S = new int[N][N]; // 시너지 배열 초기화
			min_diff = Integer.MAX_VALUE; // 맛 차이 최솟값 초기화
			// 시너지 입력
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			
			// 각 음식마다 1번 조합에 넣을지 2번 조합에 넣을지를 결정
			comb = new int[N];
			combination(0, 0, 0);
			
			// 출력
			System.out.println("#"+t+" "+min_diff);
		}
		sc.close();
	}
	
	static int calculateFlavor(int[] comb) {
		// 맛의 합 초기화
		int sum = 0;
		for (int i=0; i<comb.length; i++) {
			for (int j=i+1; j<comb.length; j++) {
				// 합에 인덱스를 바꿔주면서 각각 더해준다.
				sum += S[comb[i]][comb[j]];
				sum += S[comb[j]][comb[i]];
			}
		}
		
		return sum;
	}
	
	static void calculateFlavorDiff(int[] comb) {
		// 조합1과 조합2를 배열 초기화
		int[] comb1 = new int[N/2];
		int[] comb2 = new int[N/2];
		int cidx1 = 0;
		int cidx2 = 0;
		for (int i=0; i<N; i++) {
			// 1이면 조합1 배열에 인덱스 입력
			if (comb[i] == 1)
				comb1[cidx1++] = i;
			// 2이면 조합2 배열에 인덱스 입력
			if (comb[i] == 2)
				comb2[cidx2++] = i;
		}
//		if (cidx1 != N/2 || cidx2 != N/2) {
//			System.out.println("ERROR!");
//			return;
//		}
		// 맛을 구한다.
		int flavor_sum1 = calculateFlavor(comb1);
		int flavor_sum2 = calculateFlavor(comb2);
		// 두 조합의 맛의 차이의 절댓값을 구한다.
		int diff = Math.abs(flavor_sum1 - flavor_sum2);
		
		// 최솟값 업데이트
		min_diff = Math.min(min_diff, diff);
	}
	
	static void combination(int idx, int c1, int c2) {
		// 음식들이 알맞게 분류되었다면
		if (c1 == N/2 && c2 == N/2) {
			// 맛의 차이를 구한다.
			calculateFlavorDiff(comb);
			return;
		}
		if (c1 > N/2 || c2 > N/2 || idx >= N) {
			return;
		}
		
		combination(idx+1, c1, c2);
		if (c1 < N/2) {
			comb[idx] = 1;
			combination(idx+1, c1+1, c2);
		}
		if (c2 < N/2) {
			comb[idx] = 2;
			combination(idx+1, c1, c2+1);
		}
		
	}
}