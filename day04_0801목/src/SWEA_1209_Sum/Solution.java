package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<= 10; t++) {
			int test_case = sc.nextInt();
			int max = 0;
			int[][] arr = new int[100][100];
			
			// 입력받기, 행의 합 계산
			for (int i=0; i<100; i++) {
				int row_sum = 0;
				for (int j=0; j<100; j++) {
					int ele = sc.nextInt();
					arr[i][j] = ele;
					row_sum += ele;
				}
				max = Math.max(row_sum, max);
			}
			// 열의 합 계산
			for (int j=0; j<100; j++) {
				int col_sum = 0;
				for (int i=0; i<100; i++) {
					col_sum += arr[i][j];
				}
				max = Math.max(col_sum, max);
			}
			// 대각선 합 계산
			int left_diagonal = 0;
			int right_diagonal = 0;
			for (int i=0; i<100; i++) {
				left_diagonal += arr[i][99-i];
				right_diagonal += arr[i][i];
			}
			max = Math.max(left_diagonal, max);
			max = Math.max(right_diagonal, max);
			
			
			System.out.println("#"+test_case+" "+max);
		}
		sc.close();
	}
}