package SWEA_1289_원재의메모리복구;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			String memory = "0" + sc.next();
			int cnt = 0;
			for (int i=0; i<memory.length()-1; i++) {
				if (memory.charAt(i) != memory.charAt(i+1)) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		sc.close();
	}
}