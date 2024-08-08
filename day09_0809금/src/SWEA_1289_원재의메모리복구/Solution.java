package SWEA_1289_원재의메모리복구;

import java.util.Scanner;

public class Solution {
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
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int max = -1;
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
