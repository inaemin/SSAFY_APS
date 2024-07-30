package SWEA_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1; i<=t; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int cnt = 1;
			int j=0, k=0;
			char direction = 'r';
			while (cnt <= n*n) {
				if (direction == 'r') {
					arr[j][k] = cnt;
					cnt++;
					k++;
					if (k >= n || arr[j][k] != 0) {
						k--;
						j++;
						direction = 'd';						
					}
				} else if (direction == 'l') {
					arr[j][k] = cnt;
					cnt++;
					k--;
					if (k < 0 || arr[j][k] != 0) {
						k++;
						j--;
						direction = 'u';						
					}
				} else if (direction == 'u') {
					arr[j][k] = cnt;
					cnt++;
					j--;
					if (j < 0 || arr[j][k] != 0) {
						j++;
						k++;
						direction = 'r';						
					}
				} else if (direction == 'd') {
					arr[j][k] = cnt;
					cnt++;
					j++;
					if (j >= n || arr[j][k] != 0) {
						j--;
						k--;
						direction = 'l';						
					}
				}
			}
			System.out.println("#"+i);
			
			for (int x=0; x<n; x++) {
				for (int y=0; y<n; y++) {
					System.out.print(arr[x][y]+" ");
				}
				System.out.println('\n');
			}
			
		}
		sc.close();
	}
}