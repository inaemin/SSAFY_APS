package SWEA_1289_원재의메모리복구;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 만들어야 할 메모리 문자열 입력
			String memory = "0" + sc.next();
			int cnt = 0;
			// 0에서 1로 변하는 구간을 카운트 한다.
			for (int i=0; i<memory.length()-1; i++) {
				if (memory.charAt(i) != memory.charAt(i+1)) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}