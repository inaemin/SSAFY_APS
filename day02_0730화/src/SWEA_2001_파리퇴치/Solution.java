package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case=1; test_case<=t; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][n];
			// 입력
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max_fly = 0;
			// 최대 파리 수 계산
			for (int i=0; i<n-m+1; i++) {
				for (int j=0; j<n-m+1; j++) {
					int max = 0;
					for (int x=i; x<i+m; x++) {
						for (int y=j; y<j+m; y++) {
							max += arr[x][y];
						}
					}
					max_fly = Math.max(max_fly, max);
				}
			}
			System.out.println("#"+test_case+" "+max_fly);
		}
		sc.close();
	}
}