package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] flag = new int[n][3];
			for (int i=0; i<n; i++) {
				String line = sc.next();
				for (int j=0; j<m; j++) {
					char color = line.charAt(i);
					if (color == 'W') {
						flag[i][0]++;
					} else if (color == 'B') {
						flag[i][1]++;
					} else if (color == 'R') {
						flag[i][2]++;
					}
				}
			}
			
			// [[W, B, R], ...]
			int[][] repaint_flag = new int[n][3];
			for (int i=0; i<n; i++) {
				// W로 만들기 위해 바꿔야 하는 수
				repaint_flag[i][0] = flag[i][1] + flag[i][2];
				// B로 만들기 위해 바꿔야 하는 수
				repaint_flag[i][1] = flag[i][0] + flag[i][2];
				// R로 만들기 위해 바꿔야 하는 수
				repaint_flag[i][2] = flag[i][0] + flag[i][1];
			}
			
			// 첫째줄과 마지막줄은 무조건 흰줄과 빨간줄이 되어야 함
			int cnt = 0;
			char line = 'W';
			cnt += repaint_flag[0][0]; // 첫째줄
			cnt += repaint_flag[n-1][2]; // 마지막줄
			for (int i=1; i<n-1; i++) {
				
			}
			
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}
