package swea4615;

import java.util.Scanner;

public class Solution {
	private static final char BLACK = 'B';
	private static final char WHITE = 'W';
	private static final char EMPTY = '-';
	
	private static boolean findMatchingColor(char[][] board, int r, int c, int rowMove, int colMove, char color) {
		int n = board.length;
		int pairRow = r;
		int pairCol = c;
		System.out.println(rowMove+", "+colMove+", ");
		while (true) {
			pairRow += rowMove;
			pairCol += colMove;
			if (pairRow >= 0 && pairRow < n && pairCol >= 0 && pairCol < n) {
				if (board[pairRow][pairCol] == color) {
					flipStoneBetween(board, r, c, pairRow, pairCol, rowMove, colMove, color);
					return true;
				} else if (board[pairRow][pairCol] == EMPTY) {
					return false;
				}
			} else {
				return false;
			}
		}
	}
	
	private static void flipStoneBetween(char[][] board, int startRow, int startCol, int endRow, int endCol, int rowMove, int colMove, char color) {
		int r = startRow;
		int c = startCol;
		while (r != endRow || c != endCol) {
			if (board[r][c] != color) 
				board[r][c] = color;
			r += rowMove;
			c += colMove;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt(); // 보드의 한 변의 길이
			int m = sc.nextInt(); // 플레이어가 돌을 놓는 횟수
			// 1이면 흑돌, 2이면 백돌
			// (2, 3) -> 배열상에는 (2, 1) 좌표로 변경
			char [][] board = new char[n][n];
			// EMPTY로 초기화
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					board[i][j] = EMPTY;
				}
			}
			// 가운데 4개 배치
			board[n/2-1][n/2-1] = WHITE;
			board[n/2][n/2] = WHITE;
			board[n/2][n/2-1] = BLACK;
			board[n/2-1][n/2] = BLACK;
			// 흑돌, 백돌 놓기
			for (int p=0; p<m; p++) {
				int y = sc.nextInt() - 1;
				int x = sc.nextInt() - 1;
				char color = sc.nextInt() == 1 ? BLACK : WHITE;
				board[x][y] = color;
				// 수직검사
				findMatchingColor(board, x, y, -1, 0, color);
				findMatchingColor(board, x, y, 1, 0, color);
				// 수평검사
				findMatchingColor(board, x, y, 0, -1, color);
				findMatchingColor(board, x, y, 0, 1, color);
				// 왼쪽대각선검사
				// x,y 둘 중에 작은
				// (3,2)라면 (2,1) (1,0)
				//          (4,3)
				findMatchingColor(board, x, y, -1, -1, color);
				findMatchingColor(board, x, y, 1, 1, color);
				// 오른쪽대각선검사
				// (3, 2)라면 (2, 3), (1, 4) (0, 5)
				// (4, 1), (5, 0)
				// x는 빼고 y는 더함.
				findMatchingColor(board, x, y, -1, 1, color);
				findMatchingColor(board, x, y, 1, -1, color);
			}
			// 흑돌, 백돌 개수 세기
			int b_count = 0;
			int w_count = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (board[i][j] == BLACK)
						b_count++;
					else if (board[i][j] == WHITE)
						w_count++; 
				}
			}
			// 출력
			System.out.println("#"+t+" "+b_count+" "+w_count);
		}
	sc.close();
	}
}
