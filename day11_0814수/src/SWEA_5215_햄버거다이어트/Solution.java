package SWEA_5215_햄버거다이어트;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	private static int dfs(int[][] arr, int total_cal) {
		
	}
	
	private static void sort(int[][] arr) {
		for (int i=1; i<arr.length; i++) {
			int[] data = arr[i];
			int j = i;
			for (int k=i-1; k>=0 && arr[k][0] < data[0]; k--) {
				arr[k+1] = arr[k];
				j = k;
			}
			for (int k=j-1; k>=0 && arr[k][0] == data[0] && arr[k][1] > data[1]; k--) {
				arr[k+1] = arr[k];
				j = k;
			}
			arr[j] = data;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int N = sc.nextInt(); // 재료의 수
			int L = sc.nextInt(); // 제한 칼로리
			// 맛에 대한 점수와 칼로리 입력
			// 칼로리가 낮은 순으로 정렬하고, 같으면 맛이 높은 순으로 정렬.
			int[][] calories = new int[N][2]; // [맛, 칼로리]
			for (int i=0; i<N; i++) {
				calories[i][0] = sc.nextInt();
				calories[i][1] = sc.nextInt();
			}
			sort(calories);
			System.out.println(Arrays.deepToString(calories));
			
			int max_score = 0;
			// 재귀?
			for (int i=0; i<calories.length; i++) {
				if (calories[i][1] <= L) {
					int cal = L - calories[i][1];
					int score = calories[i][0];
					for (int j=i+1; j<calories.length; j++) {
						if (calories[j][1] <= cal) {
							score += calories[j][0];
							cal -= calories[j][1];							
						}
					}
					max_score = Math.max(max_score, score);
				}
			}
			// 출력
			System.out.println("#"+t+" "+max_score);
		}
		sc.close();
	}
}
