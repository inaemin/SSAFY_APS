package SWEA_14229_백만개의정수정렬;

import java.util.Scanner;

public class Solution_병합정렬 {
	static final int N = 1000000;
	static int[] arr;
	static int[] tmp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		tmp = new int[N];
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 병합정렬
		mergeSort(0, N-1);
		
		System.out.println(arr[500000]);
		
		sc.close();
	}
	
	
	// left: 구간의 시작위치 / right: 구간의 끝
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	// left: 시작구간, right: 끝구간, mid: 왼쪽 끝
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽구간의 시작 포인트
		int R = mid+1; // 오른쪽구간의 시작 포인트
		int idx = left; // tmp 배열의 인덱스
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i=L; i<=mid; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		else {
			for (int i=R; i<=right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		for (int i=left; i<=right; i++) {
			arr[i] = tmp[i];
		}
	}
	
}
