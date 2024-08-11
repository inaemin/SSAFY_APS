package swea4014;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 한 변의 길이
			int n = sc.nextInt();
			// 경사로의 길이
			int x = sc.nextInt();
			// 땅의 높이 입력
			int[][] land = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					land[i][j] = sc.nextInt();
				}
			}
			
			// 활주로가 건설되는 조건
			// 높이가 변화되는 구간에 설치되어야 하고,
			// 최소 x개의 동일한 높이의 땅이 있어야 함.
			// 경사로는 겹치면 안됨.
			// 행 검사
			int cnt = 0;
			for (int i=0; i<n; i++) {
				// 경사로를 만들 수 있는지의 여부.
				boolean isPossible = true;
				// 마지막 경사로가 지어진 인덱스.
				int lastRunway = -1;
				out: for (int j=0; j<n-1; j++) {
					int diff = Math.abs(land[i][j] - land[i][j+1]);
					if (diff == 1) {
						// 왼쪽이 낮은 경우
						if (land[i][j] < land[i][j+1]) {
							for (int xx=0; xx<x; xx++) {
								if (j-xx <= lastRunway || j-xx < 0 || land[i][j-xx] != land[i][j]) {
									isPossible = false;
									break out;
								}
							}
							lastRunway = j;
						// 오른쪽이 낮은 경우
						} else {
							for (int xx=0; xx<x; xx++) {
								if (j+1+xx <= lastRunway || j+1+xx >= n || land[i][j+1+xx] != land[i][j+1]) {
									isPossible = false;
									break out;
								}
							}
							lastRunway = j+x;
						}
						
					} else if (diff > 1) {
						isPossible = false;
						break;
					} else if (diff == 0) {
						continue;
					}
				}
				if (isPossible)
					cnt++;
			}
			// 열 검사
			for (int j=0; j<n; j++) {
				// 경사로를 지을 수 있는지의 여부.
				boolean isPossible = true;
				// 마지막 경사로가 지어진 인덱스.
				int lastRunway = -1;
				out : for (int i=0; i<n-1; i++) {
					int diff = Math.abs(land[i][j] - land[i+1][j]);
					if (diff == 1) {
						// 위쪽이 낮은 경우
						if (land[i][j] < land[i+1][j]) {
							for (int xx=0; xx<x; xx++) {
								if (i-xx <= lastRunway || i-xx < 0 || land[i-xx][j] != land[i][j]) {
									isPossible = false;
									break out;
								}
							}
							lastRunway = i;
						// 아랫쪽이 낮은 경우
						} else {
							for (int xx=0; xx<x; xx++) {
								if (i+1+xx <= lastRunway || i+1+xx >= n || land[i+1+xx][j] != land[i+1][j]) {
									isPossible = false;
									break out;
								}
							}
							lastRunway = i+x;
						}
					} else if (diff > 1) {
						isPossible = false;
						break;
					} else if (diff == 0) {
						continue;
					}
				}
				if (isPossible)
					cnt++;
			}
			// 출력
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}
