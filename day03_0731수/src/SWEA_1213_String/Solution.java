package SWEA_1213_String;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int num = sc.nextInt();
			int cnt = 0;
			String str = sc.next();
			String sentence = sc.next();
			out: for (int i=0; i<sentence.length(); i++) {
				if (sentence.charAt(i) == str.charAt(0)) {
					for (int j=1; j<str.length(); j++) {
						if (i+j > sentence.length()-1 || sentence.charAt(i+j) != str.charAt(j)) {
							continue out;
						}
					}
					cnt++;
				}
			}
			System.out.println("#"+num+" "+cnt);
		}
		sc.close();
	}
}