package SWEA_1859_백만장자프로젝트;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 배열의 크기
			int n = sc.nextInt();
			// 배열 초기화, 배열 입력
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 이익 변수 설정
			long profit = 0;
			int max = 0;
			for (int i=n-1; i>=0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				} else {
					profit += max - arr[i];
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+profit);
			
		}
		sc.close();
	}
}