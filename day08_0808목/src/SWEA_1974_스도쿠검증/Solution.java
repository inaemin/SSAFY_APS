package SWEA_1974_스도쿠검증;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static final int SIZE = 9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		out: for (int t=1; t<=tc; t++) {
			// 스도쿠판 초기화
			int[][] board = new int[SIZE][SIZE];
			// 스도쿠 입력
			for (int i=0; i<SIZE; i++) {
				for (int j=0; j<SIZE; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			Set<Integer> set = new HashSet<>();
			// 행 검사
			for (int i=0; i<SIZE; i++) {
				for (int j=0; j<SIZE; j++) {
					set.add(board[i][j]);
				}
				// set 사이즈 확인 후 9가 아니라면 0으로 출력하고
				// 바깥 for문으로 이동
				if (set.size() != 9) {
					System.out.println("#"+t+" "+ 0);
					continue out;
				}
				set.clear();
			}
			// 열 검사
			for (int j=0; j<SIZE; j++) {
				for (int i=0; i<SIZE; i++) {
					set.add(board[i][j]);
				}
				if (set.size() != 9) {
					System.out.println("#"+t+" "+ 0);
					continue out;
				}
				set.clear();
			}
			
			// 3x3 검사
			// 1, 4, 7
			for (int i=1; i<SIZE; i+=3) {
				for (int j=1; j<SIZE; j+=3) {
					for (int m=i-1; m<=i+1; m++) {
						for (int n=j-1; n<=j+1; n++) {
							set.add(board[m][n]);							
						}
					}
					if (set.size() != 9) {
						System.out.println("#"+t+" "+ 0);
						continue out;
					}
					set.clear();
				}
			}
			
			System.out.println("#"+t+" "+ 1);
		}
		
		sc.close();
	}
}