package 정렬;

import java.util.Arrays;

public class Solution {
	/*
	 * 대표적인 정렬 방식의 종류
	 * - 버블 정렬: 비효율적이지만 이해하기 쉬움.
	 * - 선택 정렬
	 * - 삽입 정렬
	 * - 카운팅 정렬
	 * - 병합 정렬
	 * - 퀵 정렬
	 * 
	 * 버블 정렬
	 * - 인접한 두 개의 원소를 비교한 후 교환하는 과정을 반복하여
	 *   데이터를 정렬하는 방식
	 * - 시간 복잡도: O(n^2)
	 * */
	
	static void bubbleSort() {
		// 배열의 초기화
		int[] arr = {55, 7, 78, 12, 42};
		
		// 버블 정렬
		
		// i: 각 사이클마다 최대 데이터가 정렬될 위치
		for (int i=arr.length-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void main(String[] args) {
		bubbleSort();
	}
}