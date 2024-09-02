package SWEA_1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 개수
	static int H, W; // 게임 맵의 높이, 너비
	static char[][] MAP;
	static int N; // 사용자가 넣을 입력의 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			MAP = new char[H][W];
			for (int i=0; i<H; i++) {
				String row = sc.next();
				for (int j=0; j<W; j++) {
					MAP[i][j] = row.charAt(j);
				}
			}
			
			N = sc.nextInt();
			String commands = sc.next();
			for (int i=0; i<N; i++) {
				char cm = commands.charAt(i);
			}
			
			// 출력
			System.out.println();
		}
		sc.close();
	}
}