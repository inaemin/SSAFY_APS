package SWEA_2068_최대수구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int max = 0;
			for (int j=0; j<10; j++) {
				max = Math.max(sc.nextInt(), max);
			}
			System.out.println("#"+(i+1)+" "+max);
		}
		sc.close();
	}
}
