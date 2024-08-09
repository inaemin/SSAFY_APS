package swea4014;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[][] land = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					land[i][j] = sc.nextInt();
				}
			}
			
			
		}
		sc.close();
	}
}
