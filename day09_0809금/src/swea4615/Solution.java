package swea4615;

import java.util.Scanner;

public class Solution {
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
			// 가운데 4개 배치
			board[n/2-1][n/2-1] = 'W';
			board[n/2][n/2] = 'W';
			board[n/2][n/2-1] = 'B';
			board[n/2-1][n/2] = 'B';
			// 흑돌, 백돌 놓기
			for (int p=0; p<m; p++) {
				int y = sc.nextInt() - 1;
				int x = sc.nextInt() - 1;
				char color = sc.nextInt() == 1 ? 'B' : 'W';
				board[x][y] = color;
				// 수직검사
				boolean hasSameColor = false;
				for (int i=0; i<=x-1; i++) {
					if (board[i][y] == color)
						hasSameColor = true;						
					if (hasSameColor == true && board[i][y] != color)
						board[i][y] = color;
				}
				hasSameColor = false;
				for (int i=n-1; i>=x+1; i--) {
					if (board[i][y] == color)
						hasSameColor = true;
					if (hasSameColor && board[i][y] != color)
						board[i][y] = color;
				}
				hasSameColor = false;
				// 수평검사
				for (int j=0; j<=y-1; j++) {
					if (board[x][j] == color)
						hasSameColor = true;
					if (hasSameColor && board[x][j] != color)
						board[x][j] = color;
				}
				hasSameColor = false;
				for (int j=n-1; j>=y+1; j--) {
					if (board[x][j] == color)
						hasSameColor = true;
					if (hasSameColor && board[x][j] != color)
						board[x][j] = color;
				}
				hasSameColor = false;
				// 왼쪽대각선검사
				// x,y 둘 중에 작은
				// (3,2)라면 (2,1) (1,0)
				//          (4,3)
				for (int i=Math.min(x, y); i>=1; i--) {
					if (board[x-i][y-i] == color)
						hasSameColor = true;
					if (hasSameColor && board[x-i][y-i] != color)
						board[x-i][y-i] = color;
				}
				hasSameColor = false;
				for (int i=n-1-Math.max(x, y); i>=1; i--) {
					if (board[x+i][y+i] == color)
						hasSameColor = true;
					if (hasSameColor && board[x+i][y+i] != color)
						board[x+i][y+i] = color;
				}
				hasSameColor = false;
				// 오른쪽대각선검사
				// (3, 2)라면 (2, 3), (1, 4) (0, 5)
				// (4, 1), (5, 0)
				// x는 빼고 y는 더함.
				for (int i=Math.min(x, n-1-y); i>=1; i--) {
					if (board[x-i][y+i] == color)
						hasSameColor = true;
					if (hasSameColor && board[x-i][y+i] != color)
						board[x-i][y+i] = color;
				}
				hasSameColor = false;
				for (int i=Math.min(n-1-x, y); i>=1; i--) {
					if (board[x+i][y-i] == color)
						hasSameColor = true;
					if (hasSameColor && board[x+i][y-i] != color)
						board[x+i][y-i] = color;
				}
				hasSameColor = false;
			}
			
			// 흑돌, 백돌 개수 세기
			int b_count = 0;
			int w_count = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (board[i][j] == 'B')
						b_count++;
					else if (board[i][j] == 'W')
						w_count++; 
				}
			}
			// 출력
			System.out.println("#"+t+" "+b_count+" "+w_count);
		}
		sc.close();
	}
}
