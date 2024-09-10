package sort;

import java.util.Arrays;

public class 카운팅정렬 {

	public static void main(String[] args) {
		int[] arr = { 4, 9, 11, 23, 2, 19, 7 };

		int K = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > K) {
				K = arr[i];
			}
		}

		int[] count = new int[K + 1];

		for (int i = 0; i < arr.length; i++)
			count[arr[i]]++;
		System.out.println(Arrays.toString(count));
		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];
		System.out.println(Arrays.toString(count));

		int[] sortedArr = new int[arr.length];
		System.out.println(Arrays.toString(sortedArr));
		
		// 거꾸로 돌면서 sortedArr에 넣어줌
		// 연산자를 앞에 넣어줘야 배열인덱스 오류나지 않음.
		for (int i = arr.length - 1; i >= 0; i--)
			sortedArr[--count[arr[i]]] = arr[i];
		System.out.println(Arrays.toString(sortedArr));
	}

}
