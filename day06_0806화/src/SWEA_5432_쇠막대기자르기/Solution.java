package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			String input = sc.next();
			int cnt = 0;
			int stick = 0;
			for (int i=0; i<input.length(); i++) {
				if (i < input.length()-1 && input.charAt(i) == '(' && input.charAt(i+1) == ')') {
					// 레이저
					// 쇠막대기를 카운트에 더해준다.
					cnt += stick;
					i++;
				} else if (input.charAt(i) == '(') {
					// 새로운 쇠막대기
					stick++;
				} else if (input.charAt(i) == ')') {
					// 쇠막대기 끝
					stick--;
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}