package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			// n<=m 가정
			// n으로 만들 수 있는 최소값 => n+1
			// 1로 만들 수 있는 최대값 사이의 숫자들 => 1+m
			int min = Math.min(n+1, m+1);
			int max = Math.max(n+1, m+1);
			
			// 출력
			System.out.print("#"+t);
			for (int i=min; i<=max; i++) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
		sc.close();
	}
}