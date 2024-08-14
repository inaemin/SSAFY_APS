package SWEA_5656_벽돌깨기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int N = sc.nextInt(); // 구슬을 쏠 수 있는 횟수
			int W = sc.nextInt(); // 가로길이
			int H = sc.nextInt(); // 세로길이
			// 보드의 벽돌 입력
			int[][] board = new int[H][W];
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			// 최대한 많은 벽돌을 깨뜨려
			// 남은 벽돌의 개수를 구하기
			
		}
		sc.close();
	}
}
