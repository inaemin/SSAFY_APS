package SWEA_1206_View;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i=1; i<=10; i++) {
			int cnt = 0;
			int len = sc.nextInt();
			int[] arr = new int[len];
			for (int j=0; j<len; j++) {
				arr[j] = sc.nextInt();
			}
			for (int k=0; k<len; k++) {
				if (arr[k] > 0) {
					int left_max = Math.max(arr[k-2], arr[k-1]);
					int right_max = Math.max(arr[k+1], arr[k+2]);
					int max = Math.max(left_max, right_max);
					if (arr[k] > max)
						cnt += arr[k] - max;					
				}
			}
			System.out.println("#"+i+" "+cnt);
		}
		sc.close();
	}
}
