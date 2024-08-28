package SWEA_14229_백만개의정수정렬;

import java.util.Scanner;

public class Solution_퀵정렬_호어파티션 {
	static final int N = 1000000;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 퀵정렬, 호어파티션
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
		int i = left-1; // 작은 값들의 경계
		for (int j=left; j<right; j++) {
			if (arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		return i+1;
	}	
}
