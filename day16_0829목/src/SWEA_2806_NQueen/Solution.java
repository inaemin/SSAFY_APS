package SWEA_2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 개수
	static int N; // 체스판의 크기와 퀸의 개수
	static int count; // 가능한 퀸 배치의 총 개수
	static int[] queens; // 각 행에 있는 퀸의 열 위치를 저장하는 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			count = 0;
			queens = new int[N];
			backtrack(0);
			// 출력
			System.out.println("#"+t+" "+count);
		}
		sc.close();
	}
	
	static void backtrack(int row) {
		if (row == N) {
			count++;
			return;
		}
		
		for (int col=0; col<N; col++) {
			if (isValid(row, col)) {
				queens[row] = col;
				backtrack(row + 1);
			}
		}
	}
	
	static boolean isValid(int row, int col) {
		for (int i=0; i<row; i++) {
			// 같은 열에 있거나 대각선 상에 있는 경우 false 반환
			if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}
}