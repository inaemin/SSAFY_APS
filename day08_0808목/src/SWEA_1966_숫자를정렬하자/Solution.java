package SWEA_1966_숫자를정렬하자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 배열의 길이 입력
			int n = sc.nextInt();
			int[] arr = new int[n];
			// 배열 요소 입력
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}

			// 스왑할 인덱스 초기화
			int j;
			// 배열을 돌면서 자신의 위치보다 왼쪽에 있는 요소와 비교하면서
			// 자신보다 큰 요소가 보일때까지 스왑한다.
			// 그리고 스왑이 끝나면 arr[j+1]자리에 data를 넣는다.
			for (int i=1; i<n; i++) {
				int data = arr[i];
				for (j=i-1; j>=0 && arr[j] > data; j--) {
					arr[j+1] = arr[j];
				}
				arr[j+1] = data;
			}
			
			// 출력
			System.out.print("#"+t);
			for (int i=0; i<n; i++) {
				System.out.print(" "+arr[i]);
			}
			System.out.println();
		}
		sc.close();
	}
}