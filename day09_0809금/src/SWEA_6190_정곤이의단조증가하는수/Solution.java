package SWEA_6190_정곤이의단조증가하는수;

import java.util.Scanner;

public class Solution {
	// 단조 증가하는 수인지 판단하는 함수
	private static boolean isMonotonicallyIncreasing(int num) {
		String numStr = Integer.toString(num);
		for (int i=0; i<numStr.length()-1; i++) {
			if (numStr.charAt(i) > numStr.charAt(i+1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수 입력
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int max = -1;
			// 만들 수 있는 곱 중에 단조 증가하는 수를 찾고 max값을 업데이트 한다.
			for (int i=0; i<n; i++) {
				for (int j=i+1; j<n; j++) {
					int multiple = arr[i] * arr[j];
					if (isMonotonicallyIncreasing(multiple)) {
						max = Math.max(max, multiple);
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
		sc.close();
	}
}
