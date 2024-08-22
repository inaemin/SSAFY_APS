package SWEA_16504_Gravity;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int t = sc.nextInt();
		for (int i=1; i<=t; i++) {
			// 방의 가로 길이
			int row = sc.nextInt();
			// 상자 입력
			int[] arr = new int[row];
			for (int j=0; j<row; j++) {
				arr[j] = sc.nextInt();
			}
			// 최대 낙차
			int max = 0;
			for (int j=0; j<arr[0]; j++) {
				// 낙차 카운트
				int cnt = 0;
				for (int k=1; k<row; k++) {
					// 다음 행의 박스가 0이거나
					// 높이가 다음 행의 높이보다 크다면 낙차 증가
					if (arr[k] == 0 || j+1 > arr[k])
						cnt++;
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#"+(i)+" "+max);
		}
		sc.close();
	}
}
