package SWEA_1210_ladder1;

import java.util.Scanner;

public class Solution {
	private static final int SIZE = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int tc = sc.nextInt();
			// 100x100의 보드 초기화
			int[][] board = new int[SIZE][SIZE];
			// 도착지 좌표 x, y
			int endR = 0;
			int endC = 0;
			// 보드 입력받기
			for (int i=0; i<SIZE; i++) {
				for (int j=0; j<SIZE; j++) {
					int ele = sc.nextInt();
					board[i][j] = ele;
					// 도착지 좌표 저장
					if (ele == 2) {
						endR = i;
						endC = j;		                                                    										
					}
				}
			}
			
			char dir = 'u';
			while (endR != 0) {
				// dir = 'u'
				// 위로 이동
				// 위쪽도 1인데 왼쪽 또는 오른쪽이 1이라면 dir 변경
				if (dir == 'u') {
					if (endC-1 >= 0 && board[endR][endC-1] == 1) {
						dir = 'l';
						endC--;
					} else if (endC+1 < SIZE && board[endR][endC+1] == 1) {
						dir = 'r';
						endC++;
					} else if (board[endR-1][endC] == 1) {
						endR--;
					}
				}
				
				// dir = 'l'
				// 위쪽이 1이 나올때까지 왼쪽으로 이동
				if (dir == 'l') {
					if (board[endR-1][endC] != 1) {
						endC--;
					} else {
						dir = 'u';
						endR--;						
					}
				}
				
				// dir = 'r'
				// 위쪽이 1이 나올때까지 오른쪽으로 이동
				if (dir == 'r') {
					if (board[endR-1][endC] != 1) {
						endC++;
					} else {
						dir = 'u';
						endR--;						
					}
				}
			}
			
			System.out.println("#"+tc+" "+endC);
		}
		sc.close();
	}
}