package SWEA_1860_진기의최고급붕어빵;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	// 삽입정렬
	private static void sort(int[] arr) {
		int j;
		for (int i=1; i<arr.length; i++) {
			int data = arr[i];
			for (j=i-1; j>=0 && arr[j] > data; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = data;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// n명의 손님
			int n = sc.nextInt();
			// m초의 시간을 들이면 k개의 붕어빵을 만듦
			int m = sc.nextInt();
			int k = sc.nextInt();
			// n명의 손님이 도착하는 시간
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			// 오름차순 정렬
			sort(arr);
			// 1개의 붕어빵을 만들기 위한 시간 k/m*n
			// n개의 붕어빵을 만들기 위한 시간
			// 마지막 손님이 도착하는 시간 arr[arr.length-1]
			int last_customer_time = arr[arr.length-1];
			int[] fish_time_cnt = new int[last_customer_time+1];
			for (int i=0; i<fish_time_cnt.length; i+=m) {
				for (int j=0; j<m && i+j < fish_time_cnt.length; j++) {
					fish_time_cnt[i+j] = fish_time_cnt[i] + k;
				}
			}
			System.out.println(Arrays.toString(fish_time_cnt));
			
			// 모든 사람이 기다리는 시간이 없이 붕어빵을 제공할 수 있으면
			// "Possible", 아니면 "Impossible"을 출력
			boolean isPossible = true;
			
			// 출력
			System.out.println("#"+t+" "+(isPossible ? "Possible" : "Impossible"));
		}
		sc.close();
	}
}