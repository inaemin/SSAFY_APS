package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 번호
	static int C, N; // 밑, 지수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			T = sc.nextInt();
			C = sc.nextInt();
			N = sc.nextInt();
			int answer = recur(C, N);
			System.out.println("#"+T+" "+answer);
		}
		sc.close();
	}
	
	static int recur(int c, int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n % 2 == 0) {
			return recur(c, n/2) * recur(c, n/2);
		} else {
			return c * recur(c, (n-1)/2) * recur(c, (n-1)/2);
		}
	}
}