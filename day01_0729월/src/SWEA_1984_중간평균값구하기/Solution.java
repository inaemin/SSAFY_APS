package SWEA_1984_중간평균값구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			double sum = 0;
			int min = 10001;
			int max = 0;
			for (int j=0; j<10; j++) {
				int input = sc.nextInt();
				sum += input;
				min = Math.min(min, input);
				max = Math.max(max, input);
			}
			sum -= min;
			sum -= max;
			System.out.println("#"+i+" "+Math.round(sum/8));
		}
		sc.close();
	}
}
