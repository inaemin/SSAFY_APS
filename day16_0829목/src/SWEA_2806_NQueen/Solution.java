package SWEA_2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			int answer = 0;
			// 출력
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}
}