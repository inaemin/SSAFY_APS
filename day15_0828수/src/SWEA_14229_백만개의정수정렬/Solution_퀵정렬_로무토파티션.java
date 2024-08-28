package SWEA_14229_백만개의정수정렬;

import java.util.Scanner;

public class Solution_퀵정렬_로무토파티션 {
	static final int N = 1000000;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 퀵정렬, 로무토파티션
		quickSort(0, N-1);
		
		System.out.println(arr[500000]);
		
		sc.close();
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}

	// 반환값은 피봇의 위치
	private static int partition(int left, int right) {
		int pivot = arr[right];
		int L = left+1, R = right;
		while (L <= R) {
			// L: pivot보다 큰 값을 찾을 때까지 이동을 하겠다.
			while (L <= R && arr[L] <= pivot) {
				L++;
			}
			// R: pivot보다 작거나 같은 값을 만날 때까지 이동을 하겠다.
			while (arr[R] > pivot) {
				R--;
			}
			
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		// R의 위치는 사실 피봇이 가야할 위치이다.
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		// 피봇의 위치
		return R;
	}	
}
