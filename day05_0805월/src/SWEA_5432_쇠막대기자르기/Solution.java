package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// ()(((()())(())()))(())
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			String[] arr = sc.next().split("");
			int cnt = 1;
			int stick = 0;
			for (int i=0; i<arr.length-1; i++) {
				if (i < arr.length-1 && arr[i].equals("(") && arr[i+1].equals(")")) {
					// 레이저
					// 쇠막대기를 카운트에 더해준다.
					// i++;
					cnt += stick;
					i++;
				} else if (arr[i].equals("(")) {
					// 새로운 쇠막대기
					// stick++;
					stick++;
				} else if (arr[i].equals(")")) {
					// 쇠막대기 끝
					// stick--;
					stick--;
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}