package SWEA_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스의 수
	static int N, K; // N개의 자연수, 합이 K가 되는 경우의 수를 구하라.
	static int[] arr;
	static int count; // 경우의 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			count = 0; // 경우의 수 초기화
			dfs(0, 0);
			
			// 출력
			System.out.println("#"+t+" "+count);
		}
		sc.close();
	}
	
	static void dfs(int idx, int sum) {
		if (idx >= N) {
			if (sum == K) {
				count++;
			}
			return;
		}
		
		// idx에 해당하는 원소 선택. sum에 더해준다.
		dfs(idx+1, sum + arr[idx]);
		// idx에 해당하는 원소 선택하지 않음. sum에 더하지 않는다.
		dfs(idx+1, sum);
	}
	
}