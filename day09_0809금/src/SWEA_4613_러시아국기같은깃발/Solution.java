package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// n개의 줄에 m개의 문자로 이루어진 문자열이 주어진다
			int n = sc.nextInt();
			int m = sc.nextInt();
			// 각 줄에 색깔의 개수를 담을 배열
			int[][] flag = new int[n][3];
			for (int i=0; i<n; i++) {
				// 문자열 입력
				String line = sc.next();
				for (int j=0; j<m; j++) {
					char color = line.charAt(j);
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
			int[][] repaintCost = new int[n][3];
			for (int i=0; i<n; i++) {
				// W로 만들기 위해 바꿔야 하는 수
				repaintCost[i][0] = flag[i][1] + flag[i][2];
				// B로 만들기 위해 바꿔야 하는 수
				repaintCost[i][1] = flag[i][0] + flag[i][2];
				// R로 만들기 위해 바꿔야 하는 수
				repaintCost[i][2] = flag[i][0] + flag[i][1];
			}
			
			int min_cnt = Integer.MAX_VALUE;
			for (int i=1; i<=n-2; i++) {
				for (int j=i+1; j<n; j++) {
					// 첫째줄과 마지막줄은 무조건 흰줄과 빨간줄이 되어야 함
					// i는 B가 시작되는 위치
					// j는 R가 시작되는 위치
					// 0~i-1까지가 W
					// i~j-1까지가 B
					// j~n-1까지가 R
					int cnt = 0;
					for (int w=0; w<i; w++) {
						cnt += repaintCost[w][0];
					}
					for (int b=i; b<j; b++) {
						cnt += repaintCost[b][1];
					}
					for (int r=j; r<n; r++) {
						cnt += repaintCost[r][2];
					}
					min_cnt = Math.min(cnt, min_cnt);
				}
			}
			
			System.out.println("#"+t+" "+min_cnt);
		}
		sc.close();
	}
}
