package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	private static int dfs(int base, int square) {
		if (square == 1)
			return base;
		return dfs(base, --square) * base;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc=1; tc<=10; tc++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println("#"+t+" "+dfs(n, m));
		}
		sc.close();
	}
}