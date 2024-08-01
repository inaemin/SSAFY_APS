package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=0; t<10; t++) {
			int len = sc.nextInt();
			int[][] arr = new int[8][8];
			for (int i=0; i<len; i++) {
				String row_str = sc.next();
				for (int j=0; j<len; j++) {
					arr[i][j] = row_str.charAt(j);
				}
			}
			
			int cnt = 0;
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		
		sc.close();
	}
}